## **INICIAL WEB PAGE**
In the folder Client_ exits the file index.html to open the webpage
In the folder Server, there is the spring project in the folder named CoursProject

    .
    ├── Client_                   
    │   └── index.html --> To open the web page
    ├── Server                    
    │   └── CoursProject --> Folder to open the spring project



## **USERS**
| ROLE | USER | PASSWORD |
------------- | ------------- |------------- |
| ROLE_ADMIN | jbarberan@edu.tecnocampus.cat | password123 |
| ROLE_BROKER | lguiti@edu.tecnocampus.cat | password123 |
| ROLE_BIDDER | rvidal@edu.tecnocampus.cat | password123 |
    
## **HOW TO NAVIGATE**
Inicial page
![image](https://user-images.githubusercontent.com/59828377/102487866-814e4200-406b-11eb-8b15-f9f91b03c11b.png)

It's necessary to login
![image](https://user-images.githubusercontent.com/59828377/102487954-9fb43d80-406b-11eb-8644-dd22d81346be.png)
![image](https://user-images.githubusercontent.com/59828377/102488073-ca05fb00-406b-11eb-95b4-ec46b2d3e113.png)

After insert the correct login(email) and password
![image](https://user-images.githubusercontent.com/59828377/102488047-c1152980-406b-11eb-875e-ddab11cfd523.png)

In the menu we can see the different actions that can do the different type of user (the menu change depending on the role)
![image](https://user-images.githubusercontent.com/59828377/102488153-e7d36000-406b-11eb-8bed-5c0b575b12d5.png)


## **FUNCTIONALLITY**
(We can see it in the front end)
- **Sign in** ROLE_BIDDER,
- **Register new user** ALL
- **Show user information** ROLE_BIDDER, ROLE_ADMIN, ROLE_BROKER
- **Update user information** ROLE_BIDDER, ROLE_ADMIN, ROLE_BROKER
- **Show current auctions** ROLE_BIDDER, ROLE_ADMIN
        - **Show an auction** ROLE_BIDDER, ROLE_ADMIN
        - **Particepe in an auction** ROLE_BIDDER, ROLE_ADMIN
- **Show user auctions history** ROLE_ADMIN, ROLE_BIDDER
- **Show the user won auctions** ROLE_ADMIN, ROLE_BIDDER
- **Buy bitcoins**  ROLE_ADMIN, ROLE_BROKER
- **Organize an auction** ROLE_ADMIN, ROLE_BROKER
- **Show the user transaction history** ROLE_ADMIN, ROLE_BROKER
- **Show the comissions** ROLE_ADMIN


(Backend)
- Crono for update the finished auctions and distribute the bitcoins and the money
- Security 
- AOP
- Database is in Azure
- Front end exceptions
