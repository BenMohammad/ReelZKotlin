package com.benmohammad.reelzapp.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.benmohammad.reelzapp.R
import com.benmohammad.reelzapp.adapter.Comm
import com.benmohammad.reelzapp.adapter.SnippetAdapter
import com.benmohammad.reelzapp.data.model.Snippet
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class SnippetsActivity : AppCompatActivity(), Comm {

    var arr: ArrayList<Snippet>? = null
    private var adView: AdView? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snippets)

        adView = findViewById(R.id.advertBanner)
        val adRequest =
            AdRequest.Builder().build()
        adView!!.loadAd(adRequest)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        arr = ArrayList()
        loadSnippets()
    }

    private fun loadSnippets() {
        arr!!.clear()
        val obj1 = Snippet(
            "Lambda (Basic)", """import java.util.ArrayList;

public class LambdaInJava {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(9);
    numbers.add(8);
    numbers.add(1);
    numbers.forEach( (n) -> { System.out.println(n); } );
  }
}"""
        )
        val obj2 = Snippet(
            "Filter", """import java.util.ArrayList;  
import java.util.List;  
import java.util.stream.Stream;   
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class FilterInJava{  
    public static void main(String[] args) {  
        List<Product> list=new ArrayList<Product>();  
        list.add(new Product(1,"Samsung A5",100f));  
        list.add(new Product(3,"Iphone 6S",300f));  
        list.add(new Product(2,"Sony Xperia",200f));  
        list.add(new Product(4,"Nokia Lumia",150f));  
        list.add(new Product(5,"Redmi4 ",260f));  
        list.add(new Product(6,"Lenevo Vibe",190f));  
          
    
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 200);  
          
    
        filtered_data.forEach(  
                product -> System.out.println(product.name+": "+product.price)  
        );  
    }  
}"""
        )
        val obj3 = Snippet(
            "Functional Interface", """@FunctionalInterface
interface GenericInterface<T> {

    
    T func(T t);
}

public class FunctionalImplementationInJava {

    public static void main( String[] args ) {

        GenericInterface<String> reverse = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
            result += str.charAt(i);
            return result;
        };

        System.out.println("Lambda reversed = " + reverse.func("Lambda"));

        GenericInterface<Integer> factorial = (n) -> {

            int result = 1;
            for (int i = 1; i <= n; i++)
            result = i * result;
            return result;
        };

        System.out.println("factorial of 5 = " + factorial.func(5));
    }
}"""
        )
        val obj4 = Snippet(
            "Fibonacci", """import java.util.List;
import java.util.stream.*;

public class FibonacciInJava {
   public static void main(String args[]) {
      System.out.println(FibonacciTest.generate(10));
   }
   public static List generate(int series) {
      return Stream.iterate(new int[]{0, 1}, s -> new int[]{s[1], s[0] + s[1]}) /
                  .limit(series)
     .map(n -> n[0])
     .collect(Collectors.toList());
   }
}"""
        )
        val obj5 = Snippet(
            "DoubleConsumer", """import java.util.function.DoubleConsumer;

public class DoubleConsumerInJava {
   public static void main(String args[]) {
      DoubleConsumer increment = doubleVal -> {       
         System.out.println("Incrementing " + doubleVal + " by one");
         System.out.println("Current Value : "+ (doubleVal+1));
      };
      DoubleConsumer decrement = doubleVal -> {       
         System.out.println("Decrementing " + doubleVal + " by one");
         System.out.println("Current Value : " + (doubleVal-1));
      };
      DoubleConsumer result = increment.andThen(decrement);
      result.accept(777);
   }
}"""
        )
        val obj6 = Snippet(
            "Streamn",
            """import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 
public class StreamInJava {
  public static void main(String[] args) {
    List<Integer> intLst = Arrays.asList(1, 2, 3, 4);

    List<Integer> newLst = intLst.stream()
                    .map(n->n*2)
                      .collect(Collectors.toList());
    
    System.out.println(newLst);
    // [2, 4, 6, 8]
  }
}"""
        )
        val obj7 = Snippet(
            "BiFunction", """import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionInJava {

    public static void main(String[] args) {

        
        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;

        Integer result = func.apply(2, 3);

        System.out.println(result); 

        
        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);

        Double result2 = func2.apply(2, 4);

        System.out.println(result2);    

        // take two Integers and return a List<Integer>
        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);

        List<Integer> result3 = func3.apply(2, 3);

        System.out.println(result3);

    }

}"""
        )
        val obj8 = Snippet(
            "BiFunction Advanced", """import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionInJava {

    public static void main(String[] args) {

        // Take two Integers, pow it into a Double, convert Double into a String.
        String result = convert(2, 4,
                (a1, a2) -> Math.pow(a1, a2),
                (r) -> "Pow : " + String.valueOf(r));

        System.out.println(result);     

        // Take two Integers, multiply into an Integer, convert Integer into a String.
        String result2 = convert(2, 4,
                (a1, a2) -> a1 * a1,
                (r) -> "Multiply : " + String.valueOf(r));

        System.out.println(result2);    

        // Take two Strings, join both, join "cde"
        String result3 = convert("a", "b",
                (a1, a2) -> a1 + a2,
                (r) -> r + "cde");      

        System.out.println(result3);

        // Take two Strings, join both, convert it into an Integer
        Integer result4 = convert("100", "200",
                (a1, a2) -> a1 + a2,
                (r) -> Integer.valueOf(r));

        System.out.println(result4);    

    }

    public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2,
                                              BiFunction<A1, A2, R1> func,
                                              Function<R1, R2> func2) {

        return func.andThen(func2).apply(a1, a2);

    }

}"""
        )
        val obj9 = Snippet(
            "BiPredicate", """import java.util.function.BiPredicate;

public class BiPredicateInJava {

    public static void main(String[] args) {

        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("ReelZ", 5);
        System.out.println(result);  

        boolean result2 = filter.test("java", 10);
        System.out.println(result2); 
    }

}"""
        )
        val obj10 = Snippet(
            "BiPredicate Advanced", """import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class BiPredicateInJava {

    public static void main(String[] args) {

        List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                new Domain("reelz.com", 10),
                new Domain("spam.com", 0),
                new Domain("love.com", 2));

        BiPredicate<String, Integer> bi = (domain, score) -> {
            return (domain.equalsIgnoreCase("google.com") || score == 0);
        };

        // if google or score == 0
        List<Domain> result = filterBadDomain(domains, bi);
        System.out.println(result); 

        //  if score == 0
        List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 0);
        System.out.println(result2); 

        // if start with i or score > 5
        List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
        System.out.println(result3); 

        // chaining with or
        List<Domain> result4 = filterBadDomain(domains, bi.or(
                (domain, x) -> domain.equalsIgnoreCase("microsoft.com"))
        );
        System.out.println(result4); 


    }

    public static <T extends Domain> List<T> filterBadDomain(
            List<T> list, BiPredicate<String, Integer> biPredicate) {

        return list.stream()
                .filter(x -> biPredicate.test(x.getName(), x.getScore()))
                .collect(Collectors.toList());

    }
}

        class Domain {

        String name;
        Integer score;

        public Domain(String name, Integer score) {
            this.name = name;
            this.score = score;
         }
    
}"""
        )
        val obj11 = Snippet(
            "UnaryOperator", """import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorInJava {

    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> x * 2;

        Integer result = func.apply(2);

        System.out.println(result);         

        UnaryOperator<Integer> func2 = x -> x * 2;

        Integer result2 = func2.apply(2);

        System.out.println(result2);        

    }

}"""
        )
        val obj12 = Snippet(
            "Supplier",
            """import java.util.Date;
import java.util.function.Supplier;
public class SupplierInJava {
 public static void main(String args[]) {
  //Supplier instance with lambda expression
  Supplier<String> helloStrSupplier = () -> new String("Hello");
  String helloStr = helloStrSupplier.get();
  System.out.println("String in helloStr is->"+helloStr+"<-");
   
  //Supplier instance using method reference to default constructor
  Supplier<String> emptyStrSupplier = String::new;
  String emptyStr = emptyStrSupplier.get();
  System.out.println("String in emptyStr is->"+emptyStr+"<-");
   
  //Supplier instance using method reference to a static method
  Supplier<Date> dateSupplier= SupplierFunctionExample::getSystemDate;
  Date systemDate = dateSupplier.get();
  System.out.println("systemDate->" + systemDate);
 }
 public static Date getSystemDate() {
  return new Date();
 }
}"""
        )
        val obj13 = Snippet(
            "TriFunction",
            """interface TriFunction<T, U, V, R> {
  R apply(T t, U u, V v);
}
class Sum {
  Integer doSum(String s1, String s2) {
    return Integer.parseInt(s1) + Integer.parseInt(s1);
  }
}
public class TriFunctionJava {
 public static void main(String args[]) {
TriFunction<Sum, String, String, Integer> lambda =
  (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1);
System.out.println(lambda.apply(new Sum(), "1", "4")); }
}
"""
        )
        val obj14 = Snippet(
            "Predicate",
            """public class PredicateInJava {

   public static void main(String args[]) {
      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		
      System.out.println("Print all numbers:");
		
      eval(list, n->true);
		
		
      System.out.println("Print even numbers:");
      eval(list, n-> n%2 == 0 );
		
		
      System.out.println("Print numbers greater than 3:");
      eval(list, n-> n > 3 );
   }
	
   public static void eval(List<Integer> list, Predicate<Integer> predicate) {

      for(Integer n: list) {

         if(predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
   }
}"""
        )
        val obj15 = Snippet(
            "ToIntBiFunction",
            """import java.util.function.ToIntBiFunction;
public class ToIntBiFunctionInJava {
   public static void main(String args[]) {
      ToIntBiFunction<Integer, Integer> test = (t, u) -> t * u;
      System.out.println("The multiplication of t and u is: " + test.applyAsInt(8, 15));
      System.out.println("The multiplication of t and u is: " + test.applyAsInt(10, 7));
   }
}
"""
        )
        val obj16 = Snippet(
            "Optional",
            """import java.util.Optional;

public class OptionalInJava {

	public static void main(String[] args) {

		
		Optional<Void> emptyOptional = Optional.empty();

		
		System.out.println(" Is optional is empty : " + emptyOptional.isEmpty());

		
		Optional<String> stringOptional = Optional.of("Hello");

		if (stringOptional.isPresent()) {
			System.out.println("Getting value from stringOptional : " + stringOptional.get());
		}

		
		Optional<Integer> intOptionbal = Optional.of(1244);
		System.out.println("Integer Optional: " + intOptionbal.get());
		
		Optional<String> ofNullable = Optional.ofNullable("Non null value");

		String content = ofNullable.get();
		System.out.println("Ofnullable value :" + content);

		
		Optional nullOptional = Optional.ofNullable(null);
		nullOptional.get();
	}
}"""
        )
        val obj17 = Snippet(
            "Optional Advanced",
            """import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalIfPresentInJava {
	public static void main(String[] args) {

		System.out.println("Example 1 : ------ Optional string ------ ");
		
		Optional<String> optional = Optional.ofNullable("ReelZ");

		
		optional.ifPresent(value -> System.out.println(value));

		System.out.println("Example 2 : ------  Optional List of integers ------ ");

		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		
		Optional<List<Integer>> numbersOfListOptional = Optional.ofNullable(list);

		
		numbersOfListOptional.ifPresent(optionalList -> optionalList.forEach(v -> System.out.println(v)));

		Optional empty = Optional.empty();
		empty.ifPresent(valeu -> System.out.println("no value"));

	}
}"""
        )
        val obj18 = Snippet(
            "DoubleFunction", """import java.util.function.DoubleFunction;
public class DoubleFunctionInJava {
   public static void main(String[] args) {
      DoubleFunction<String> getGrade = marks -> { 
         if(marks > 90 && marks <= 100) {
            return "A";
         }
         else if(marks > 70 && marks <= 90) {
            return "B";
         }
         else if(marks > 50 && marks <= 70) {
            return "C";
         }
         else {
            return "D";
         }
      };
      double input = 95;
      System.out.println("Input Marks: " + input);
      String grade = getGrade.apply(input);
      System.out.println("Grade : "+ grade + "\n");
      input = 85;
      System.out.println("Input Marks: " + input);
      System.out.println("Grade : " + getGrade.apply(input) + "\n");
      input = 67;
      System.out.println("Input Marks: " + input);
      System.out.println("Grade : " + getGrade.apply(input) + "\n");
      input = 49;
      System.out.println("Input Marks: " + input);
      System.out.println("Grade : " + getGrade.apply(input));
   }
}"""
        )
        arr!!.add(obj1)
        arr!!.add(obj2)
        arr!!.add(obj3)
        arr!!.add(obj4)
        arr!!.add(obj5)
        arr!!.add(obj6)
        arr!!.add(obj7)
        arr!!.add(obj8)
        arr!!.add(obj9)
        arr!!.add(obj10)
        arr!!.add(obj11)
        arr!!.add(obj12)
        arr!!.add(obj13)
        arr!!.add(obj14)
        arr!!.add(obj15)
        arr!!.add(obj16)
        arr!!.add(obj17)
        arr!!.add(obj18)

        val l1 = findViewById<ListView>(R.id.snippets_list)
        l1.adapter = SnippetAdapter(arr!!, applicationContext, this)
    }

    override fun sendCodeToEditor(snippet: String) {
        val i = Intent()
        i.putExtra("snippet", snippet)
        Log.d("i am here:", snippet)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }
            R.id.info -> {
                val intent = Intent(this, InfoActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.snippets_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}