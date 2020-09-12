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
import com.google.android.gms.ads.MobileAds


class SnippetsActivity : AppCompatActivity(), Comm {

    var arr: ArrayList<Snippet>? = null
    private var adView: AdView? = null

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snippets)
        supportActionBar!!.title = ""

        MobileAds.initialize(this) {}
        var mAdView = findViewById<AdView>(R.id.advertBanner)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        arr = ArrayList()
        loadSnippets()
    }

    private fun loadSnippets() {
        arr!!.clear()
        val obj1 = Snippet(
            "Lambda", "import java.util.ArrayList;\n" +
        "\n" +
                "public class LambdaInJava {\n" +
                "  public static void main(String[] args) {\n" +
                "    ArrayList<Integer> numbers = new ArrayList<Integer>();\n" +
                "    numbers.add(5);\n" +
                "    numbers.add(9);\n" +
                "    numbers.add(8);\n" +
                "    numbers.add(1);\n" +
                "    numbers.forEach( (n) -> { System.out.println(n); } );\n" +
                "  }\n" +
                "}"

        )
        val obj2 = Snippet(
            "Filter", "import java.util.ArrayList;  \n" +
                    "import java.util.List;  \n" +
                    "import java.util.stream.Stream;   \n" +
                    "class Product{  \n" +
                    "    int id;  \n" +
                    "    String name;  \n" +
                    "    float price;  \n" +
                    "    public Product(int id, String name, float price) {  \n" +
                    "        super();  \n" +
                    "        this.id = id;  \n" +
                    "        this.name = name;  \n" +
                    "        this.price = price;  \n" +
                    "    }  \n" +
                    "}  \n" +
                    "public class FilterInJava{  \n" +
                    "    public static void main(String[] args) {  \n" +
                    "        List<Product> list=new ArrayList<Product>();  \n" +
                    "        list.add(new Product(1,\"Samsung A5\",100f));  \n" +
                    "        list.add(new Product(3,\"Iphone 6S\",300f));  \n" +
                    "        list.add(new Product(2,\"Sony Xperia\",200f));  \n" +
                    "        list.add(new Product(4,\"Nokia Lumia\",150f));  \n" +
                    "        list.add(new Product(5,\"Redmi4 \",260f));  \n" +
                    "        list.add(new Product(6,\"Huawei p30 Pro\",490f));  \n" +
                    "          \n" +
                    "    \n" +
                    "        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 200);  \n" +
                    "          \n" +
                    "    \n" +
                    "        filtered_data.forEach(  \n" +
                    "                product -> System.out.println(product.name+\": \"+product.price)  \n" +
                    "        );  \n" +
                    "    }  \n" +
                    "}")


        val obj3 = Snippet(
            "Functional Interface", "@FunctionalInterface\n" +
                    "interface GenericInterface<T> {\n" +
                    "\n" +
                    "    T func(T t);\n" +
                    "}\n" +
                    "\n" +

                    "public class FunctionalImplementationInJava {\n" +
                    "\n" +
                    "    public static void main( String[] args ) {\n" +
                    "\n" +
                    "        GenericInterface<String> reverse = (str) -> {\n" +
                    "\n" +
                    "            String result = \"\";\n" +
                    "            for (int i = str.length()-1; i >= 0 ; i--)\n" +
                    "            result += str.charAt(i);\n" +
                    "            return result;\n" +
                    "        };\n" +
                    "\n" +
                    "        System.out.println(\"Lambda reversed = \" + reverse.func(\"Lambda\"));\n" +
                    "\n" +
                    "        GenericInterface<Integer> factorial = (n) -> {\n" +
                    "\n" +
                    "            int result = 1;\n" +
                    "            for (int i = 1; i <= n; i++)\n" +
                    "            result = i * result;\n" +
                    "            return result;\n" +
                    "        };\n" +
                    "\n" +
                    "        System.out.println(\"factorial of 5 = \" + factorial.func(5));\n" +
                    "    }\n" +
                    "}")


        val obj4 = Snippet(
            "DoubleConsumer", "import java.util.function.DoubleConsumer;\n" +
                    "\n" +
                    "public class DoubleConsumerInJava {\n" +
                    "   public static void main(String args[]) {\n" +
                    "      DoubleConsumer increment = doubleVal -> {       \n" +
                    "         System.out.println(\"Incrementing \" + doubleVal + \" by one\");\n" +
                    "         System.out.println(\"Current Value : \"+ (doubleVal+1));\n" +
                    "      };\n" +
                    "      DoubleConsumer decrement = doubleVal -> {       \n" +
                    "         System.out.println(\"Decrementing \" + doubleVal + \" by one\");\n" +
                    "         System.out.println(\"Current Value : \" + (doubleVal-1));\n" +
                    "      };\n" +
                    "      DoubleConsumer result = increment.andThen(decrement);\n" +
                    "      result.accept(777);\n" +
                    "   }\n" +
                    "}")

        val obj5 = Snippet(
            "Streamn",
            "import java.util.Arrays;\n" +
                    "import java.util.List;\n" +
                    "import java.util.stream.Collectors;\n" +
                    " \n" +
                    "public class StreamInJava {\n" +
                    "  public static void main(String[] args) {\n" +
                    "    List<Integer> intLst = Arrays.asList(1, 2, 3, 4);\n\n" +
                    "    List<Integer> newLst = intLst.stream()\n" +
                    "                    .map(n->n*2)\n" +
                    "                      .collect(Collectors.toList());\n" +
                    "    \n" +
                    "    System.out.println(newLst);\n" +
                    "    // [2, 4, 6, 8]\n" +
                    "  }\n" +
                    "}")

        val obj6 = Snippet(
            "BiFunction", "import java.util.Arrays;\n" +
                    "import java.util.List;\n" +
                    "import java.util.function.BiFunction;\n" +
                    "\n" +
                    "public class BiFunctionInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        \n" +
                    "        BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;\n" +
                    "\n" +
                    "        Integer result = func.apply(2, 3);\n" +
                    "\n" +
                    "        System.out.println(result); \n" +
                    "\n" +
                    "        \n" +
                    "        BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);\n" +
                    "\n" +
                    "        Double result2 = func2.apply(2, 4);\n" +
                    "\n" +
                    "        System.out.println(result2);    \n" +
                    "\n" +

                    "        BiFunction<Integer, Integer, List<Integer>> func3 = (x1, x2) -> Arrays.asList(x1 + x2);\n" +
                    "\n" +
                    "        List<Integer> result3 = func3.apply(2, 3);\n" +
                    "\n" +
                    "        System.out.println(result3);\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}"
        )
        val obj7 = Snippet(
            "BiFunction Advanced", "import java.util.function.BiFunction;\n" +
                    "import java.util.function.Function;\n" +
                    "\n" +
                    "public class BiFunctionInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +

                    "        String result = convert(2, 4,\n" +
                    "                (a1, a2) -> Math.pow(a1, a2),\n" +
                    "                (r) -> \"Pow : \" + String.valueOf(r));\n" +
                    "\n" +
                    "        System.out.println(result);     \n" +
                    "\n" +
                    "        String result2 = convert(2, 4,\n" +
                    "                (a1, a2) -> a1 * a1,\n" +
                    "                (r) -> \"Multiply : \" + String.valueOf(r));\n" +
                    "\n" +
                    "        System.out.println(result2);    \n" +
                    "\n" +
                    "        String result3 = convert(\"a\", \"b\",\n" +
                    "                (a1, a2) -> a1 + a2,\n" +
                    "                (r) -> r + \"cde\");      \n" +
                    "\n" +
                    "        System.out.println(result3);\n" +
                    "\n" +
                    "        Integer result4 = convert(\"100\", \"200\",\n" +
                    "                (a1, a2) -> a1 + a2,\n" +
                    "                (r) -> Integer.valueOf(r));\n" +
                    "\n" +
                    "        System.out.println(result4);    \n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2,\n" +
                    "                                              BiFunction<A1, A2, R1> func,\n" +
                    "                                              Function<R1, R2> func2) {\n" +
                    "\n" +
                    "        return func.andThen(func2).apply(a1, a2);\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}")

        val obj8 = Snippet(
            "BiPredicate", "import java.util.function.BiPredicate;\n" +
                    "\n" +
                    "public class BiPredicateInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        BiPredicate<String, Integer> filter = (x, y) -> {\n" +
                    "            return x.length() == y;\n" +
                    "        };\n" +
                    "\n" +
                    "        boolean result = filter.test(\"ReelZ\", 5);\n" +
                    "        System.out.println(result);  \n" +
                    "\n" +
                    "        boolean result2 = filter.test(\"java\", 10);\n" +
                    "        System.out.println(result2); \n" +
                    "    }\n" +
                    "\n" +
                    "}")


        val obj9 = Snippet(
            "UnaryOperator", "import java.util.function.Function;\n" +
                    "import java.util.function.UnaryOperator;\n" +
                    "\n" +
                    "public class UnaryOperatorInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        Function<Integer, Integer> func = x -> x * 2;\n" +
                    "\n" +
                    "        Integer result = func.apply(2);\n" +
                    "\n" +
                    "        System.out.println(result);         \n" +
                    "\n" +
                    "        UnaryOperator<Integer> func2 = x -> x * 2;\n" +
                    "\n" +
                    "        Integer result2 = func2.apply(2);\n" +
                    "\n" +
                    "        System.out.println(result2);        \n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}")
        val obj10 = Snippet(
            "Supplier",
            "import java.time.LocalDateTime;\n" +
                    "import java.time.format.DateTimeFormatter;\n" +
                    "import java.util.function.Supplier;\n" +
                    "\n" +
                    "public class SupplierInJava {\n" +
                    "\n" +
                    "    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm:ss\");\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        Supplier<LocalDateTime> s = () -> LocalDateTime.now();\n" +
                    "        LocalDateTime time = s.get();\n" +
                    "\n" +
                    "        System.out.println(time);\n" +
                    "\n" +
                    "        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());\n" +
                    "        String time2 = s1.get();\n" +
                    "\n" +
                    "        System.out.println(time2);\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}")
        val obj11 = Snippet(
            "TriFunction",
            "interface TriFunction<T, U, V, R> {\n" +
                    "  R apply(T t, U u, V v);\n" +
                    "}" +
                    "\n" +
                    "class Sum {\n" +
                    "  Integer doSum(String s1, String s2) {\n" +
                    "    return Integer.parseInt(s1) + Integer.parseInt(s1);\n" +
                    "  }\n" +
                    "}" +
                    "\n" +

                    "public class TriFunctionJava {\n" +

                    "public static void main(String args[]) {\n" +
                    "TriFunction<Sum, String, String, Integer> lambda =\n" +
                    "  (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg1);\n" +
                    "System.out.println(lambda.apply(new Sum(), \"1\", \"4\"));" +
                    " }\n" +
                    "}\n" +
                    "")

        val obj12 = Snippet(
            "Predicate",
            "import java.util.Arrays;\n" +
                    "import java.util.List;\n" +
                    "import java.util.function.Predicate;\n" +
                    "import java.util.stream.Collectors;\n" +
                    "\n" +
                    "public class PredicateInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        List<String> list = Arrays.asList(\"A\", \"AA\", \"AAA\", \"B\", \"BB\", \"BBB\");\n" +
                    "\n" +
                    "        System.out.println(StringProcessor.filter(\n" +
                    "                list, x -> x.startsWith(\"A\")));                    // [A, AA, AAA]\n" +
                    "\n" +
                    "        System.out.println(StringProcessor.filter(\n" +
                    "                list, x -> x.startsWith(\"A\") && x.length() == 3)); // [AAA]\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "class StringProcessor {\n" +
                    "    static List<String> filter(List<String> list, Predicate<String> predicate) {\n" +
                    "        return list.stream().filter(predicate::test).collect(Collectors.toList());\n" +
                    "    }\n" +
                    "}")

        val obj13 = Snippet(
            "ToIntBiFunction",
            "import java.util.function.ToIntBiFunction;\n" +
                    "public class ToIntBiFunctionInJava {\n" +
                    "   public static void main(String args[]) {\n" +
                    "      ToIntBiFunction<Integer, Integer> test = (t, u) -> t * u;\n" +
                    "      System.out.println(\"The multiplication of t and u is: \" + test.applyAsInt(8, 15));\n" +
                    "      System.out.println(\"The multiplication of t and u is: \" + test.applyAsInt(10, 7));\n" +
                    "   }\n" +
                    "}\n")

        val obj14 = Snippet(
            "Optional",
            "import java.util.Optional;\n" +
                    "\n" +
                    "public class OptionalInJava {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        Optional<String> gender = Optional.of(\"MALE\");\n" +
                    "        String answer1 = \"Yes\";\n" +
                    "        String answer2 = null;\n" +
                    "\n" +
                    "        System.out.println(\"Non-Empty Optional:\" + gender);\n" +
                    "        System.out.println(\"Non-Empty Optional: Gender value : \" + gender.get());\n" +
                    "        System.out.println(\"Empty Optional: \" + Optional.empty());\n" +
                    "\n" +
                    "        System.out.println(\"ofNullable on Non-Empty Optional: \" + Optional.ofNullable(answer1));\n" +
                    "        System.out.println(\"ofNullable on Empty Optional: \" + Optional.ofNullable(answer2));\n" +
                    "\n" +

                    "    }\n" +
                    "\n" +
                    "}"
        )

        val obj15 = Snippet(
            "Optional Advanced",
            "import java.util.Optional;\n" +
                    "\n" +
                    "public class OptionalIfPresentExample {\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "\n" +
                    "        Optional<String> gender = Optional.of(\"MALE\");\n" +
                    "        Optional<String> emptyGender = Optional.empty();\n" +
                    "\n" +
                    "        if (gender.isPresent()) {\n" +
                    "            System.out.println(\"Value available.\");\n" +
                    "        } else {\n" +
                    "            System.out.println(\"Value not available.\");\n" +
                    "        }\n" +
                    "\n" +
                    "        gender.ifPresent(g -> System.out.println(\"In gender Option, value available.\"));\n" +
                    "\n" +
                    "        //condition failed, no output print\n" +
                    "        emptyGender.ifPresent(g -> System.out.println(\"In emptyGender Option, value available.\"));\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}")

        val obj16 = Snippet(
            "DoubleFunction", "import java.util.function.DoubleFunction;\n" +
                    "public class DoubleFunctionInJava {\n" +
                    "   public static void main(String[] args) {\n" +
                    "      DoubleFunction<String> getGrade = marks -> { \n" +
                    "         if(marks > 90 && marks <= 100) {\n" +
                    "            return \"A\";\n" +
                    "         }\n" +
                    "         else if(marks > 70 && marks <= 90) {\n" +
                    "            return \"B\";\n" +
                    "         }\n" +
                    "         else if(marks > 50 && marks <= 70) {\n" +
                    "            return \"C\";\n" +
                    "         }\n" +
                    "         else {\n" +
                    "            return \"D\";\n" +
                    "         }\n" +
                    "      };\n" +
                    "      double input = 95;\n" +
                    "      System.out.println(\"Input Marks: \" + input);\n" +
                    "      String grade = getGrade.apply(input);\n" +
                    "      System.out.println(\"Grade : \"+ grade + \"\\n\");\n" +
                    "      input = 85;\n" +
                    "      System.out.println(\"Input Marks: \" + input);\n" +
                    "      System.out.println(\"Grade : \" + getGrade.apply(input) + \"\\n\");\n" +
                    "      input = 67;\n" +
                    "      System.out.println(\"Input Marks: \" + input);\n" +
                    "      System.out.println(\"Grade : \" + getGrade.apply(input) + \"\\n\");\n" +
                    "      input = 49;\n" +
                    "      System.out.println(\"Input Marks: \" + input);\n" +
                    "      System.out.println(\"Grade : \" + getGrade.apply(input));\n" +
                    "   }\n" +
                    "}")


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

        val l1 = findViewById<ListView>(R.id.snippets_list)
        l1.adapter = SnippetAdapter(arr!!, applicationContext, this)
    }

    override fun sendCodeToEditor(snippet: String) {
        val i = Intent()
        i.putExtra("snippet", snippet)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
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