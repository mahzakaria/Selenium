@Amazon

    Feature: Test Miravia search functionality

    
        @Cart
        Scenario Outline: As a custumer, when I search for Playstation5, I want to see if he third option on the second page is available is available for purchase and can be added to the cart.
        Given The user navigates to www.miravia.es
        And Search for <Product>
        And Navigate to the page number 2
        When Select the third item
        Then The user is able to add it to the cart

        Examples:
            | Product  |
            | Playstation5  |