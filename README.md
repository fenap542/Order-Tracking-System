**Project Functionalities with description:** 

Concepts used: 

•File handling  
File -1: For storing user information 

•Exception handling 
 
**1.User login and sign-in.**
 
During login, 

•	User id 
•	Password 

Are taken as input and are checked as if user exist or not and if password the given user id is correct or not. 
 
**2.Create an Order.**

•Order type 

1-Electronics 
2-Clothings  
3-Books 
 
 
•Payment method 

1-Cash on Delivery 
2-UPI 
3-Credit/Debit card 

•Delivery type 

1-Normal Delivery 
2-Fast Track 
 
 
**3.Track an Order.**

Tracking id is taken as input and checked if the order exist or not. 
If exist then Order details are displayed. 

Tracking id,
 Order type,
 Mode of Payment, 
 Type of Delivery, 
 Days taken to deliver, 
 Delivery Address,
 Date of Order Placement, 
 Delivery charge. 
 
  
**4.Previous Order.**

Tracking ids of all the previous orders are been displayed from the main user file. And if user wants to track any previous order. Then tracking function is called using inheritance. 
 And an option for deleting or replacing or tracking any of the previous orders. 
 
**5.Order Replacement.**

Order id is taken as input and checked if the order exist or not. 
If exist then the current order file is deleted and the Tracking id is deleted from the user file. And user is taken to create an order function. 
  
**6.Order cancellation** 

Order id is taken as input and checked if the order exist or not. 
If exist then the current order file is deleted and the Tracking id is deleted from the user file. 
