# ChowAPI

## Get the ChowAPI up and running on your local environment
1. Fork and clone this repository
2. Import the project to your text editor (Java 8, JDK 1.8.0_152)
3. Set up a local MySQL database for development. See MySQL script below for database and table creation.
4. Set up an RDS MySQL instance for production. See MySQL script below for database and table creation.
5. Add a .env file to the directory above the root directory of the project. The .env file should look like the following:

```
DB_URL=jdbc:mysql://localhost:3306/chow_api
DB_USERNAME=yourLocalUsername
DB_PASSWORD=yourLocalPassword
AWS_DB_URL=jdbc:mysql://yourAwsUrl.rds.amazonaws.com/chow_api
AWS_DB_USERNAME=yourAWSUsername
AWS_DB_PASSWORD=yourAWSPassword
```

6. Send requests to the endpoints below at `localhost:5000/`

### MySQL Scripts

```
CREATE DATABASE  IF NOT EXISTS `chow_api`;
USE `chow_api`;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  google_id varchar(45) NOT NULL,
  photo_url varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE wishlist (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  user_id int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE restaurant (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  image_url varchar(225) DEFAULT NULL,
  url varchar(225) NOT NULL,
  rating DOUBLE(2,1),
  review_count int(11),
  price varchar(45),
  yelp_id varchar(225),
  display_address varchar(225),
  latitude decimal(20, 17),
  latitude decimal(20, 17),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE wishlist_restaurant (
  restaurant_id int(11) NOT NULL,
  wishlist_id int(11) NOT NULL,
  PRIMARY KEY (restaurant_id, wishlist_id),
  CONSTRAINT FK_restaurant_id FOREIGN KEY (restaurant_id) REFERENCES restaurant (id),
  CONSTRAINT FK_wishlist_id FOREIGN KEY (wishlist_id) REFERENCES wishlist (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

```

## API Endpoints

### GET /users

Get a list of all users

### POST /users

Checks if a user exists, and creates the user if they don't. Expects response body with the following format:
```
{
  "username": "User's Name",
  "email": "user@email.com",
  "googleId": "UsersGoogleId",
  "photoUrl": "UsersPhotoUrl"
}
```

### GET /users/{userId}/wishlists

Get a list of wishlists from a certain user

### GET /users/{userId}/wishlists/{id}

Get a specific wishlist

### PUT /users/{userId}/wishlists/{id}

Update the name of a wishlist. Expects a URL parameter `name`.

### POST /users/{userId}/wishlists

Create a wishlist for a specific user. Expects response body with the following format:
```
{
  "name": "Name of Wishlist",
  "userId": userIdNumber
}
```

### DELETE /users/{userId}/wishlists/{id}

Delete a wishlist

### POST /users/{userId}/wishlists/{wishlistId}/add

Add a restaurant to a specific wishlist. Expects response body with the following format:
```
{
  "name": "Restaurant Name",
  "imageUrl": "exampleImageUrl",
  "url": "https://www.yelp.com/biz/example-restaurant",
  "rating": RatingNumber,
  "reviewCount": ReviewCountNumber,
  "price": "RestaurantPrice",
  "yelpId": "example-yelp-id",
  "displayAddress": [
    "1234 Example Street",
    "Example, EX 12345"
  ],
  "latitude": ExampleLatitudeNumber,
  "longitude": ExampleLongitudeNumber
}
```

### DELETE /users/{userId}/wishlists/{wishlistId}/delete/{restaurantId}

Delete a restaurant from a wishlist
