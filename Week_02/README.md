
#### 作业6
 ```java
 public class HttpClient01 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8805");
        CloseableHttpResponse execute = build.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        InputStream content = entity.getContent();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(content, StandardCharsets.UTF_8))) {
            System.out.println("请求结果：" + reader.readLine());
        }
    }
}
 ```
 
