#### 作业1 写一段对于不同 GC 和堆内存的总结

##### GC日志分析方法

1. 启动参数  
   `-XX:+PrintGCDetails -Xmx512m -Xms512m -XX:+PrintGCDateStamps -XX:+UseSerialGC`
1. 日志示例  
   `2021-03-31T22:51:04.086+0800: [GC (Allocation Failure) 2021-03-31T22:51:04.086+0800: [DefNew: 139776K->17471K(157248K), 0.0489886 secs] 139776K->45907K(506816K), 0.0490898 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]`  
   `2021-03-31T22:51:04.702+0800: [GC (Allocation Failure) 2021-03-31T22:51:04.702+0800: [DefNew: 157193K->157193K(157248K), 0.0000609 secs]2021-03-31T22:51:04.702+0800: [Tenured: 330595K->272312K(349568K), 0.0726043 secs] 487788K->272312K(506816K), [Metaspace: 3803K->3803K(1056768K)], 0.0727806 secs] [Times: user=0.03 sys=0.00, real=0.07 secs]`  
   `2021-03-31T23:01:24.859+0800: [Full GC (Allocation Failure) 2021-03-31T23:01:24.859+0800: [Tenured: 204690K->204604K(204800K), 0.0410202 secs] 296740K->222092K(296960K), [Metaspace: 3297K->3297K(1056768K)], 0.0410779 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]`


1. 日志分析
    1. `[GC`和`[Full GC]` 说明了这次垃圾收集的停顿类型，Full表示发生了STW,如果是`System.gc()`触发的收集，则显示`[Full GC (System)`
    1. `[DefNew`、`[Tenured` 表示GC发生的区域，与收集器相关。
    1. `139776K->17471K(157248K)` 表示"GC前该内存区域已使用容量->GC后该内存区域已使用容量(该内存区域总容量)"，方括号外`296740K->222092K(296960K)`表示"GC前Java堆已使用容量->GC后Java堆已使用容量(Java堆总容量)"
    1. `0.0489886 secs` 内存区域的GC时间
    1. `[Times: user=0.03 sys=0.00, real=0.04 secs]` user 为用户态消耗的CPU时间，sys 为内核态消耗的CPU时间，real为操作开始到结束所经过的墙钟时间(Wall Clock Time)

#### 作业6 使用 HttpClient 或 OkHttp 访问  http://localhost:8801
详见homework02工程，包含服务段和客户端，服务端监听8805端口
 ```java
public class HttpClient01 {
    public static void main(String[] args) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpGet httpget = new HttpGet("http://localhost:8805");

            System.out.println("Executing request " + httpget.getMethod() + " " + httpget.getUri());
            // Create a custom response handler
            final HttpClientResponseHandler<String> responseHandler = new HttpClientResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final ClassicHttpResponse response) throws IOException {
                    final int status = response.getCode();
                    if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                        final HttpEntity entity = response.getEntity();
                        try {
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } catch (final ParseException ex) {
                            throw new ClientProtocolException(ex);
                        }
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            final String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
 ```
 
