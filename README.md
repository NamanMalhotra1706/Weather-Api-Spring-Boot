# Weather API Integration

This project demonstrates how to integrate with the OpenWeather API to fetch weather data by city name using **RestTemplate** and **ObjectMapper**.

## Technologies Used
- **Spring Boot**: Framework for building Java applications.
- **RestTemplate**: For making HTTP requests.
- **ObjectMapper (Jackson)**: For converting Java objects to JSON and vice versa.

## Key Components

### RestTemplate and ObjectMapper

#### What it is:

- **RestTemplate**: A Spring class that simplifies making HTTP requests (GET, POST, etc.) to other services or APIs. It helps in fetching data from external APIs like the OpenWeather API.

- **ObjectMapper**: A class from the Jackson library that converts Java objects to JSON and vice versa. It helps in handling JSON responses from APIs and easily converting them into Java objects.

#### Why use them:

- **RestTemplate**: Helps in making HTTP requests and directly converting the API response into a Java object.
- **ObjectMapper**: Helps in parsing the JSON response into Java objects that are easier to work with in your application.

#### Example:

```java
// RestTemplate to make an API call
RestTemplate restTemplate = new RestTemplate();
String fullResponse = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=London&appid=your_api_key", String.class);

// ObjectMapper to parse JSON response
ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(fullResponse);

// Extracting values from JSON response
String cityName = node.get("name").asText();  // "Abohar"
String country = node.get("sys").get("country").asText();  // "IN"
String weather = node.get("weather").get(0).get("main").asText();  // "Clouds"
String temp = node.get("main").get("temp").asText();  // "28.5"
String feelsLike = node.get("main").get("feels_like").asText();  // "29.3"