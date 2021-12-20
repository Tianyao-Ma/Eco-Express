# Eco-Express

<p align="center">
<img src="https://img.shields.io/badge/Backend-%20Java | Spring %20-F6922B.svg">
<img src="https://img.shields.io/badge/Frontend-%20 React | AntDesign%20-43dcf2.svg">
<img src="https://img.shields.io/badge/Framework-Spring | Hibernate %20-ec63a8.svg">
<img src="https://img.shields.io/badge/Database-%20 Postgres %20-3de540.svg">
<img src="https://img.shields.io/badge/Deployment-%20AWS EC2%20-DDC7FC.svg">
<img src="https://img.shields.io/badge/Platform-%20Fullstack Web%20-F6F063.svg">
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 🎬 About the project
<p align="justify"> 
  Delivery and online shopping became the new norm. Trunk and small vehicles are still the main tranportation. Drones and AI also became more and more intelligent and reliable. Can we combine them together and make the delivery path greener?
  We built  a Dispatch & Delivery Management Web Application. The service is to deliver small to medium scale items to residents in San Francisco using drones or robots.
We now have 3 dispatching centers in the city.
Users can sign up or login on our application, place or cancel orders, view history orders, and track ongoing orders.
We provide customized  delivery recommendations for customers according to their needs.
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## :film_strip: Project Demo
<p align="center">
<img src="https://user-images.githubusercontent.com/78308927/132066901-2767be0a-0aa8-4828-b77e-bcc45bc8348e.gif" width="800">
</p>

## 🤖 Tech Stack

* Java
* Spring
* Hibernate
* Postgres
* React
* Ant Design 3
* Amazon Web Services

## 📐 Design Doc

<p align="center">
<img src="https://user-images.githubusercontent.com/78308927/146706910-7440cd65-23e6-4eb4-9842-adef4f1675fe.jpg" width=800>
</p>

## :fire: Key Features


Visualize real time location on Google Map
API call and change state cause Synchronization
Cross domain error
Confliction of Cors  and JWT Security
Joining tables with Many to One relationship cause nested results

Changed to Google Map JS API
Implemented Promise
Utilized Spring Cors Configuration File
Added CorsFilter to Security Configuration file
Used JsonIgnore annotation

We built  a Dispatch & Delivery Management Web Application. The service is to deliver small to medium scale items to residents in San Francisco using drones or robots.
We now have 3 dispatching centers in the city.
Users can sign up or login on our application, place or cancel orders, view history orders, and track ongoing orders.
We provide customized  delivery recommendations for customers according to their needs.


- **Implemented Rest API via Spring MVC including registration, menu searching and ordering, checkout.**.
- **Utilized Hibernate to access and operate the data storage (menu, restaurants etc.)** [[Twitch API]](#twitch-api)
- **Provided both authentication and authorization via Spring security to protect the application from malicious attacks.**.
- **Used the Spring framework core technologies to loosely decouple all the components in the application**. [[Search Methods]](#search-methods)
- **Build the client side with ReactJS and Ant Design to allow users to add items to the shopping cart and place orders.**. [[Favorite Feature]](#set-and-unset-favorite-items)
- **Content-based reommendation system**. [[Recommendation System]](#content-based-recommendation)
- **Minimal, content-focused, and clutter-free frontEnd design**.

## :seedling: For Furture Improvement

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
## :spiral_notepad: Sample Code
### Twitch API
#### Retrieve real-time data from Twitch using Twitch API

 -  [Twitch API](https://dev.twitch.tv/docs/api/) is a RESTFUL API that lets developers build creative integrations for the broader Twitch community 
 -  For all users, myTwitchHub offers top game display and will allow client to search content by game name, which will fetch data by calling two Twitch APIs: [GetTopGames](https://dev.twitch.tv/docs/api/) and [getGames](https://dev.twitch.tv/docs/api/reference#get-games)
 
```
public class TwitchClient {
   
    // Returns the top x streams based on game ID.
    private List<Item> searchStreams(

