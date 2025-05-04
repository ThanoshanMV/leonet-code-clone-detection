package org.java.feature.extractor;

import org.java.feature.extractor.utility.EclipseJdtMethodFeatureExtraction;

public class MainApp {
    
    public static void main(String[] args) {
//        try {
//            List<FunctionPairWrapper> functionPairWrapperList = new ArrayList<>();
//            EclipseJdtMethodFeatureExtraction eclipseJdtMethodFeatureExtraction = new EclipseJdtMethodFeatureExtraction();
//            Reader reader = new FileReader("src/main/resources/data-1644042988517-411-unique-pairs.csv");
//            List<String[]> lines = MyCSVReader.readCSV(reader); // a line represents a row in CSV
//            int count = 0;
//            if (null != lines) {
////                iteration: 1. variable initialization 2. check condition 3. if satisfied, execute loop body 4. update expression 5. repeat
////                i = 1 ; i < 101 => 100 iterations
////                i != 0 to ignore heading line
////                10 or 20 lines at a time
//                for (int i = 1; i < 11; i++) {
////                    System.out.println("function_id_one : " + lines.get(i)[0]);
////                    System.out.println("function_one_text : " + lines.get(i)[1]);
////                    System.out.println("function_id_two : " + lines.get(i)[2]);
////                    System.out.println("function_two_text : " + lines.get(i)[3]);
//                    functionPairWrapperList.add(new FunctionPairWrapper(Integer.parseInt(lines.get(i)[0]), Integer.parseInt(lines.get(i)[2]), lines.get(i)[1], lines.get(i)[3]));
//                }
////                System.out.println("Count is :::: " + lines.size());
////                System.out.println("FunctionWrapper ::: " + functionWrapperList.size());
//                for (FunctionPairWrapper each : functionPairWrapperList) {
//                    eclipseJdtMethodFeatureExtraction.generateAST(each.getFunctionOneText());
//                    eclipseJdtMethodFeatureExtraction.generateAST(each.getFunctionTwoText());
//                }
//            } else {
//                System.out.println("Could not read the file");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        
//        // JavaParser Alone for anonymous, and local class declaration feature extraction test
//        MethodDeclaration methodDeclaration;
//        ParseResult<MethodDeclaration> methodDeclarationParseResult;
//        JavaParser javaParser = new JavaParser();
//        List<MethodReportEntry> methodReportEntries = new ArrayList<>();
//        JavaParserMethodFeatureExtraction methodFeatureExtraction = new JavaParserMethodFeatureExtraction();
//        
//        for (String methodString : Constants.methodStrings) {
//            methodDeclarationParseResult = javaParser.parseMethodDeclaration(methodString);
//            if (methodDeclarationParseResult.getResult().isPresent()) {
//                methodDeclaration = methodDeclarationParseResult.getResult().get();
//                methodReportEntries.add(methodFeatureExtraction.extractMethodFeature(methodDeclaration));
//            }
//        }
//        for (MethodReportEntry each : methodReportEntries) {
//            System.out.println(each);
//            System.out.println("\n\n");
//        }
//        
        // Eclipse JDT Alone for anonymous, and local class declaration feature extraction test
        EclipseJdtMethodFeatureExtraction eclipseJdtMethodFeatureExtraction = new EclipseJdtMethodFeatureExtraction();
//        // function 1 has one local class declaration inside a method
        eclipseJdtMethodFeatureExtraction.generateAST("    public static void validatePhoneNumber(\n" + "        String phoneNumber1, String phoneNumber2) {\n" + "      \n" + "        final int numberLength = 10;\n" + "        \n" + "        // Valid in JDK 8 and later:\n" + "       \n" + "        // int numberLength = 10;\n" + "       \n" + "        class PhoneNumber {\n" + "            \n" + "            String formattedPhoneNumber = null;\n" + "\n" + "            PhoneNumber(String phoneNumber){\n" + "                // numberLength = 7;\n" + "                String currentNumber = phoneNumber.replaceAll(\n" + "                  regularExpression, \"\");\n" + "                if (currentNumber.length() == numberLength)\n" + "                    formattedPhoneNumber = currentNumber;\n" + "                else\n" + "                    formattedPhoneNumber = null;\n" + "            }\n" + "\n" + "            public String getNumber() {\n" + "                return formattedPhoneNumber;\n" + "            }\n" + "            \n" + "            // Valid in JDK 8 and later:\n" + "\n" + "//            public void printOriginalNumbers() {\n" + "//                System.out.println(\"Original numbers are \" + phoneNumber1 +\n" + "//                    \" and \" + phoneNumber2);\n" + "//            }\n" + "        }\n" + "\n" + "        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);\n" + "        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);\n" + "        \n" + "        // Valid in JDK 8 and later:\n" + "\n" + "//        myNumber1.printOriginalNumbers();\n" + "\n" + "        if (myNumber1.getNumber() == null) \n" + "            System.out.println(\"First number is invalid\");\n" + "        else\n" + "            System.out.println(\"First number is \" + myNumber1.getNumber());\n" + "        if (myNumber2.getNumber() == null)\n" + "            System.out.println(\"Second number is invalid\");\n" + "        else\n" + "            System.out.println(\"Second number is \" + myNumber2.getNumber());\n" + "\n" + "    }");
//        // function 2 has one local class declaration and two anonymous class declarations
        eclipseJdtMethodFeatureExtraction.generateAST("public void sayHello() {\n" + "        // local class\n" + "        class EnglishGreeting implements HelloWorld {\n" + "            String name = \"world\";\n" + "            public void greet() {\n" + "                greetSomeone(\"world\");\n" + "            }\n" + "            public void greetSomeone(String someone) {\n" + "                name = someone;\n" + "                System.out.println(\"Hello \" + name);\n" + "            }\n" + "        }\n" + "      \n" + "        HelloWorld englishGreeting = new EnglishGreeting();\n" + "        // anonymous class\n" + "        HelloWorld frenchGreeting = new HelloWorld() {\n" + "            String name = \"tout le monde\";\n" + "            public void greet() {\n" + "                greetSomeone(\"tout le monde\");\n" + "            }\n" + "            public void greetSomeone(String someone) {\n" + "                name = someone;\n" + "                System.out.println(\"Salut \" + name);\n" + "            }\n" + "        };\n" + "        // anonymous class\n" + "        HelloWorld spanishGreeting = new HelloWorld() {\n" + "            String name = \"mundo\";\n" + "            public void greet() {\n" + "                greetSomeone(\"mundo\");\n" + "            }\n" + "            public void greetSomeone(String someone) {\n" + "                name = someone;\n" + "                System.out.println(\"Hola, \" + name);\n" + "            }\n" + "        };\n" + "        englishGreeting.greet();\n" + "        frenchGreeting.greetSomeone(\"Fred\");\n" + "        spanishGreeting.greet();\n" + "    }");
//
//        // output
//        // JavaParser successfully identifies each local class declaration statements in both functions and doesn't identify anonymous class declaration
//        // EclipseJDT identifies only two anonymous class declaration in the function 2 and doesn't identify local class declarations
//
//        // summary: local class declaration and anonymous class declaration are seperate
//        // JavaParser identifies local class declaration
//        // JDT identifies anonymous class declaration
        
//        eclipseJdtMethodFeatureExtraction.generateAST("    private void fieldDeclarationTest()\n" + "    {\n" + "        String email = \"hello.com\", position = \"student\";\n" + "        String name;\n" + "        String city;\n" + "    }");
    }
    
    private void fieldDeclarationTest()
    {
        String email = "hello.com", position = "student";
        String name;
        String city;
    }
}
