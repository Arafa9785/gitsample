Feature: Mobiles & Accessories

   @Test @Test_Case_1
  Scenario: Test_Case_1_Add_Screen Guards_Second Product_to_Cart_Under_Mobiles & Accessories Menu_Without Login
    Given Launch Amazon URL
    When Click on Electronics Menu Bar
    And Goto Mobiles and Accessories and Click on Screen Guards
    And Click on Second Screen Guard Product
    When Add the Second Product to the Cart
    Then Check Added To Cart Text is Displayed
    And Navigate to the Cart Section  
    Then Capture the Screenshot of Item Addded to Cart
    
    @Test @Test_Case_2
  Scenario: Test_Case_2_Add_Screen Guards_Second Product_to_Cart_Under_Mobiles & Accessories Menu_With Login
    Given Launch Amazon URL
    When Login User Account Credentials
    Then Verify User Logged Successfully
    When Click on Electronics Menu Bar
    And Goto Mobiles and Accessories and Click on Screen Guards
    And Click on Second Screen Guard Product
    When Add the Second Product to the Cart
    Then Check Added To Cart Text is Displayed
    And Navigate to the Cart Section  
    Then Capture the Screenshot of Item Addded to Cart
