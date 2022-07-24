import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Products> productsArraylist = new ArrayList<Products>();
        ArrayList<Customer> customerArrayList = new ArrayList<Customer>();
        ArrayList<Seller> sellerArrayList = new ArrayList<Seller>();
        ArrayList<ShoppingList> shoppingListArrayList = new ArrayList<ShoppingList>();

        // At first, we have these 3 products in our online shop
        Products banana = new Products("banana", 0.5);
        Products laptop = new Products("laptop", 999.99);
        Products iphone13 = new Products("iphone13", 800);

        productsArraylist.add(banana);
        productsArraylist.add(laptop);
        productsArraylist.add(iphone13);

        // Our online shop name is /MM\
        System.out.println("*WELCOME TO /MM\\ ONLINE ShOP*");

        boolean inTheMainPage = true;

        while(inTheMainPage) {

            // Things that we can do in main page
            System.out.println("\nWhat do you want to do? (Choose one of the numbers..)");
            System.out.println("1. Visiting online shop and productsArraylist");
            System.out.println("2. Sign up");
            System.out.println("3. Login");
            System.out.println("4. Exit");

            System.out.print("\nEnter your number: ");

            int numberChoosed = scanner.nextInt();
            scanner.nextLine();

            switch(numberChoosed) {
                // 1. Visiting online shop and productsArraylist ---------------------------------------------------------------------------
                case 1:
                    while(true) {
                        System.out.println("\nProducts:");

                        for(int i = 0; i < productsArraylist.size() ;i++)
                            System.out.println(productsArraylist.get(i).toString());

                        System.out.println("\nWhat do you want to do? (Choose one of the numbers..)");
                        System.out.println("1. Back");

                        System.out.print("\nEnter your number: ");
                        numberChoosed = scanner.nextInt();

                        if(numberChoosed == 1)
                            break;
                    }
                    break;
                // 2. Sign up -----------------------------------------------------------------------------------------------------
                case 2:

                    while(true) {

                        System.out.println("\nAre you a Customer or a Seller? (c/s)");
                        System.out.print("Enter a character: ");
                        String customerOrSeller = scanner.nextLine();
                        System.out.println();

                        switch(customerOrSeller.toLowerCase()) {

                            // Customer sign up
                            case "c":
                                System.out.print("UserName: ");
                                String userName = scanner.nextLine().toLowerCase();
                                System.out.print("Password: ");
                                String pass = scanner.nextLine();

                                Customer newCustomer = new Customer(userName, pass);

                                boolean haveAlreadyUsed = false;

                                for(Customer checkingCustomer : customerArrayList)
                                    if(checkingCustomer.userName.equals(userName)) {
                                        haveAlreadyUsed = true;
                                        break;
                                    }

                                if(haveAlreadyUsed)
                                    System.out.println("Choose another username!!!");
                                else {
                                    customerArrayList.add(newCustomer);
                                    System.out.println("Congratulation! :D");
                                }
                                break;

                            // Seller sign up
                            case "s":
                                System.out.print("UserName: ");
                                userName = scanner.nextLine().toLowerCase();
                                System.out.print("Password: ");
                                pass = scanner.nextLine();

                                Seller newSeller = new Seller(userName, pass);

                                haveAlreadyUsed = false;

                                for(Seller checkingSeller : sellerArrayList)
                                    if(checkingSeller.userName.equals(userName)) {
                                        haveAlreadyUsed = true;
                                        break;
                                    }

                                if(haveAlreadyUsed)
                                    System.out.println("Choose another username!!!");
                                else {
                                    sellerArrayList.add(newSeller);
                                    System.out.println("Congratulation! :D");
                                }

                                break;
                            default:
                                System.out.println("Ops.. Wrong input :(");
                        }
                        break;
                    }
                    break;
                // 3. Login ------------------------------------------------------------------------------------------------------
                case 3:
                    boolean inTheLoginPage = true;
                    while(inTheLoginPage) {

                        System.out.println("Are you a Customer or a Seller? (c/s)");
                        String customerOrSeller = scanner.nextLine();
                        System.out.println();

                        switch(customerOrSeller.toLowerCase()) {

                            // Customer Login
                            case "c":

                                if(customerArrayList.isEmpty())
                                    System.out.println("Please sign up first");
                                else {
                                    System.out.print("UserName: ");
                                    String userName = scanner.nextLine().toLowerCase();
                                    System.out.print("Password: ");
                                    String pass = scanner.nextLine();

                                    boolean haveSignUpFirst = false;


                                    for(Customer checkingCustomer : customerArrayList)
                                        if(checkingCustomer.userName.equals(userName)) {
                                            haveSignUpFirst = true;
                                            if(checkingCustomer.pass.equals(pass)) {

                                                // Customer tasks
                                                System.out.println("Login was successful :)\n");

                                                while(inTheLoginPage) {
                                                    System.out.println("\n1. See your user name");
                                                    System.out.println("2. See Shopping List History");
                                                    System.out.println("3. Search shopping list");
                                                    System.out.println("4. Buy");
                                                    System.out.println("5. Log out");

                                                    System.out.print("\nEnter your number: ");
                                                    numberChoosed = scanner.nextInt();

                                                    switch(numberChoosed) {

                                                        // 1. See your user name
                                                        case 1:
                                                            System.out.println("Your user name: " + userName);
                                                            continue;

                                                            // 2. See Shopping List History
                                                        case 2:
                                                            if(shoppingListArrayList.size() == 0)
                                                                System.out.println("Your shopping list is empty :(");
                                                            else {
                                                                System.out.println("\nYour shopping Lists:");
                                                                for(ShoppingList searchInShoppingList : customerFinder(userName,customerArrayList).shoppingListHistory)
                                                                    System.out.println(searchInShoppingList.toString());
                                                            }
                                                            continue;

                                                            // 3. Search shopping list
                                                        case 3:

                                                            System.out.print("please enter your shopping list ID: ");
                                                            int id = scanner.nextInt();

                                                            if(shoppingListIDFinder(id, shoppingListArrayList) == null)
                                                                System.out.println("This ID dosen't exist :(");
                                                            else {

                                                                for(ShoppingList searchInShoppingList : customerFinder(userName,customerArrayList).shoppingListHistory) {
                                                                    if(searchInShoppingList.id == id) {
                                                                        System.out.println(searchInShoppingList.productsArraylist);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            continue;

                                                            // 4. Buy
                                                        case 4:

                                                            for(int i = 0; i < productsArraylist.size() ;i++)
                                                                System.out.println(productsArraylist.get(i).toString());

                                                            System.out.println("\nWhat do you want to buy?");

                                                            ArrayList<Products> newProductsOfShoppingList = new ArrayList<Products>();

                                                            scanner.nextLine();
                                                            String productName = scanner.nextLine();

                                                            if(productFinder(productName, productsArraylist) == null)
                                                                System.out.println("This product doesn't exist");
                                                            else {
                                                                newProductsOfShoppingList.add(productFinder(productName, productsArraylist));
                                                            }

                                                            boolean isStillBuying = true;
                                                            while(isStillBuying) {
                                                                System.out.println("Whould you want to continue buying? (true/false)");

                                                                isStillBuying = scanner.nextBoolean();
                                                                scanner.nextLine();

                                                                if(!isStillBuying)
                                                                    break;

                                                                System.out.println("\nWhat do you want to buy?");

                                                                productName = scanner.nextLine();

                                                                if(productFinder(productName, productsArraylist) == null)
                                                                    System.out.println("This product doesn't exist");
                                                                else {
                                                                    newProductsOfShoppingList.add(productFinder(productName, productsArraylist));
                                                                }
                                                            }

                                                            System.out.println(newProductsOfShoppingList);

                                                            ShoppingList newShoppingList = new ShoppingList(newProductsOfShoppingList);
                                                            shoppingListArrayList.add(newShoppingList);
                                                            customerFinder(userName, customerArrayList).shoppingListHistory.add(newShoppingList);

                                                            continue;

                                                            // 5. Log out
                                                        case 5:
                                                            System.out.println();
                                                            inTheLoginPage = false;

                                                            break;
                                                        default:
                                                            System.out.println("Ops.. Wrong input :(");
                                                    }
                                                }

                                            }else {
                                                System.out.println("Wrong password!");
                                            }
                                            break;
                                        }
                                    if(!haveSignUpFirst) {
                                        System.out.println("Wrong username!");
                                    }
                                }

                                break;

                            // Seller Login
                            case "s":
                                if(sellerArrayList.isEmpty())
                                    System.out.println("Please sign up first");
                                else {
                                    System.out.print("UserName: ");
                                    String userName = scanner.nextLine().toLowerCase();
                                    System.out.print("Password: ");
                                    String pass = scanner.nextLine();

                                    boolean haveSignUpFirst = false;

                                    for(Seller checkingSeller : sellerArrayList)
                                        if(checkingSeller.userName.equals(userName)) {
                                            haveSignUpFirst = true;
                                            if(checkingSeller.pass.equals(pass)) {

                                                // Seller tasks
                                                System.out.println("Login was successful :)\n");

                                                while(inTheLoginPage) {
                                                    System.out.println("\n1. See your user name");
                                                    System.out.println("2. Customers list");
                                                    System.out.println("3. Number of customers");
                                                    System.out.println("4. Products list");
                                                    System.out.println("5. Add product");
                                                    System.out.println("6. Remove customer");
                                                    System.out.println("7. Customer shopping status");
                                                    System.out.println("8. Remove product");
                                                    System.out.println("9. Log out");

                                                    System.out.print("\nEnter your number: ");
                                                    numberChoosed = scanner.nextInt();

                                                    switch(numberChoosed) {

                                                        // 1. See your user name
                                                        case 1:
                                                            System.out.println("Your user name: " + userName);
                                                            continue;

                                                            // 2. Customers list
                                                        case 2:
                                                            for(Customer customerName : customerArrayList)
                                                                System.out.println(customerName);

                                                            continue;

                                                            // 3. Number of customers
                                                        case 3:
                                                            System.out.println("Number of customers: " + customerArrayList.size());

                                                            continue;

                                                            // 4. Products list
                                                        case 4:
                                                            for(Products productsList : productsArraylist)
                                                                System.out.println(productsList);
                                                            continue;

                                                            // 5. Add product
                                                        case 5:
                                                            System.out.print("Product name: ");
                                                            String productName = scanner.nextLine();
                                                            productName = scanner.nextLine();
                                                            System.out.print("Product Price: ");
                                                            double productPrice = scanner.nextDouble();

                                                            Products newProduct = new Products(productName, productPrice);

                                                            if(productsArraylist.contains(newProduct))
                                                                System.out.println("This product is exist");
                                                            else {
                                                                productsArraylist.add(newProduct);
                                                            }

                                                            continue;

                                                            // 6. Remove customer
                                                        case 6:
                                                            System.out.println("Which customer do you want to remove?");
                                                            for(Customer customerName : customerArrayList)
                                                                System.out.println(customerName);

                                                            System.out.print("Enter customer user name: ");
                                                            String customerRemove = scanner.nextLine();
                                                            customerRemove = scanner.nextLine();

                                                            if(customerFinder(customerRemove, customerArrayList).equals(null))
                                                                System.out.println("This user name doesn't exist! :(");
                                                            else {
                                                                customerArrayList.remove(customerFinder(customerRemove, customerArrayList));
                                                                System.out.println("You removed this username successfully :)");
                                                            }

                                                            continue;

                                                            // 7. Customer shopping status
                                                        case 7:

                                                            System.out.print("\nChoose one shopping list ID: ");
                                                            int shoppingListID = scanner.nextInt();

                                                            if(shoppingListIDFinder(shoppingListID, shoppingListArrayList) == null)
                                                                System.out.println("This ID doesn't exist");
                                                            else {
                                                                System.out.println(shoppingListIDFinder(shoppingListID, shoppingListArrayList));
                                                                System.out.println("\nChoose one status: ");
                                                                System.out.println("1. Processing");
                                                                System.out.println("2. Delivering");
                                                                System.out.println("3. Delivered");

                                                                System.out.print("\nEnter your number: ");
                                                                numberChoosed = scanner.nextInt();

                                                                ShoppingList shoppingList = shoppingListIDFinder(shoppingListID, shoppingListArrayList);

                                                                switch(numberChoosed) {

                                                                    // 1. Processing
                                                                    case 1:
                                                                        shoppingList.changeShoppingStatus(ShoppingStatus.Processing);
                                                                        System.out.println("successfully changed");

                                                                        break;

                                                                    // 2. Delivering
                                                                    case 2:
                                                                        shoppingList.changeShoppingStatus(ShoppingStatus.Delivering);
                                                                        System.out.println("successfully changed");

                                                                        break;

                                                                    // 3. Delivered
                                                                    case 3:
                                                                        shoppingList.changeShoppingStatus(ShoppingStatus.Delivered);
                                                                        System.out.println("successfully changed");

                                                                        break;
                                                                    default:
                                                                        System.out.println("Ops.. Wrong input :(");
                                                                }
                                                            }

                                                            continue;

                                                            // 8. Remove product
                                                        case 8:
                                                            System.out.println("Which product do you want to remove?");
                                                            for(Products productNames : productsArraylist)
                                                                System.out.println(productNames);

                                                            System.out.print("Enter product name: ");

                                                            String productRemove = scanner.nextLine();
                                                            productRemove = scanner.nextLine();

                                                            if(productFinder(productRemove, productsArraylist).equals(null))
                                                                System.out.println("This product doesn't exist! :(");
                                                            else {
                                                                productsArraylist.remove(productFinder(productRemove, productsArraylist));
                                                                System.out.println("You removed this product successfully :)");
                                                            }

                                                            continue;

                                                            // 9. Log out
                                                        case 9:
                                                            System.out.println();
                                                            inTheLoginPage = false;
                                                            break;

                                                        default:
                                                            System.out.println("Ops.. Wrong input :(");

                                                    }

                                                }

                                            }else {
                                                System.out.println("Wrong password!");
                                            }
                                            break;

                                        }
                                    if(!haveSignUpFirst)
                                        System.out.println("Wrong username!");

                                }

                                break;
                            default:
                                System.out.println("Ops.. Wrong input :(");
                        }
                        break;
                    }
                    break;

                // 4. Exit -------------------------------------------------------------------------------------------------------
                case 4:
                    System.out.println("\nHave a great day :)");
                    inTheMainPage = false;
                    break;
                // Wrong input ---------------------------------------------------------------------------------------------------
                default:
                    System.out.println("\nOps.. Wrong input :(");

            }

        }

    }

    // This method find customer
    public static Customer customerFinder(String userName, ArrayList<Customer> customerArrayList) {
        for(Customer customer : customerArrayList)
            if(userName.equals(customer.userName))
                return customer;

        return null;
    }

    // This method find product
    public static Products productFinder(String name, ArrayList<Products> productsArraylist) {
        for(Products product : productsArraylist)
            if(name.equals(product.name))
                return product;

        return null;

    }

    // This method find Shopping List by ID
    public static ShoppingList shoppingListIDFinder(int id, ArrayList<ShoppingList> shoppingListArrayList) {
        for(ShoppingList shoppingList : shoppingListArrayList)
            if(id == shoppingList.id)
                return shoppingList;

        return null;
    }

}

























