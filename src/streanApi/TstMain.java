package streanApi;

import java.util.*;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {

        Autor mike = new Autor("Mike",33);
        Autor max = new Autor("Max",22);
        Autor tom = new Autor("Tom",65);
        Autor jane = new Autor("Jane",40);
        Autor july = new Autor("July",29);

        Article article1 = new Article("Java12", mike, Article.Category.JAVA);
        Article article2 = new Article("PHP 5", max, Article.Category.PHP);
        Article article3 = new Article("PYTHON ", jane, Article.Category.PYTHON);
        Article article4 = new Article("Java 12", tom, Article.Category.JAVA);
        Article article5 = new Article("Java 9-12", july, Article.Category.JAVA);
        Article article6 = new Article("Java 11", mike, Article.Category.JAVA);
        Article article7 = new Article("PYTHON 2", jane, Article.Category.PYTHON);
        Article article8 = new Article("Java S", july, Article.Category.JAVA);
        Article article9 = new Article("PHP to start", max, Article.Category.PHP);
        Article article10 = new Article("PHP for you", max, Article.Category.PHP);


        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);
        articles.add(article10);
        System.out.println("список статей ");
        ///сгруппировать статьи по имени автора
        articles.stream().collect(Collectors.groupingBy((a -> a.getAutor().getName())))
                .entrySet()
                .forEach(System.out::println);
        System.out.println("список авторов  по алфавиту");
////вывести имена авторов по алфавиту
        articles.stream().map(a -> a.getAutor().getName())
                .distinct().sorted().forEach(System.out::println);

        System.out.println("количество статей по каждому авторув ");
///количество статей по каждому автору
        articles.stream()
                .collect(Collectors.groupingBy(a -> a.getAutor().getName(), Collectors.counting()))
                .forEach((a, cont) -> System.out.println(a + " кол статей " + cont));
        
        ///vпо категориям
        System.out.println("по категорию, ключи Мар, имя автора+ значение статьи по данной категории ");
        Map<Article.Category,Map<String, List<Article>>> map=articles.stream()
                .sorted(Comparator.comparing(Article::getCategory,Comparator.comparing(Enum::name))
                        .thenComparing(a->a.getAutor().getName()))//отсортировали
                //формируем
                .collect(Collectors.groupingBy(Article::getCategory,LinkedHashMap::new,Collectors.groupingBy(a->a.getAutor().getName())));
        System.out.println("map = " + map);
        
        ///--------------------------------------------------------------------
        ArrayList<Autor> autorArrayList=new ArrayList<>();
        autorArrayList.add(mike);
        autorArrayList.add(tom);
        autorArrayList.add(jane);
        autorArrayList.add(max);
        autorArrayList.add(july);
        System.out.println("статистика  по возрвасту" );
        ////статистика  по возрвасту
        IntSummaryStatistics statistics=autorArrayList.stream().collect(Collectors.summarizingInt(Autor::getAge));
        System.out.println("statistics = " + statistics);
        System.out.println("max возраст = " + statistics.getMax());


        ArrayList<Developer> developers=new ArrayList<>();
        developers.add(new Developer("Bob",22,15000,"manager"));
        developers.add(new Developer("Rai",35,17000,"manager"));
        developers.add(new Developer("Gary",45,77000,"director"));
        developers.add(new Developer("Alla",33,37000,"secretary"));
        developers.add(new Developer("Pall",57,47000,"driver"));


        //группируем по должности - pos
        System.out.println("группируем по должности - pos" );
        Map<String,List<Developer>> posMap=
                developers.stream().collect(Collectors.groupingBy(Developer::getPos));

        Map<String,Set<Developer>> posSet=
                developers.stream().collect(Collectors.groupingBy(Developer::getPos, Collectors.toSet()));

        // количество по должности
        System.out.println("количество по должности" );
        Map<String,Long> posCount=developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.counting()));

        System.out.println("posCount = " + posCount);
        // группировка имен по должности
        System.out.println("группировка имен по должности" );

        Map<String,Set<String>> posName= developers.stream()
                ///группировать и собрать в коллекцию mapping
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.mapping(Developer::getName,Collectors.toSet())));
        System.out.println("posName = " + posName);


        //средняя ЗП по должности
        System.out.println("средняя ЗП по должности" );
        Map<String,Double>  posAvSalary=developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,
                        Collectors.averagingDouble(Developer::getSalary)));
        System.out.println("posAvSalary = " + posAvSalary);

   ////----

        Map<String,Map<Integer,List<Developer>>> posAndAge=
                developers.stream().collect(Collectors.groupingBy(Developer::getPos,
                       Collectors.groupingBy(Developer::getAge)));



    }
}


///----------------------------------------------------
class Article {
    enum Category {JAVA, PYTHON, PHP}

    private String title;
    private Autor autor;
    private Category category;

    public Article(String title, Autor autor, Category category) {
        this.title = title;
        this.autor = autor;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (autor != null ? !autor.equals(article.autor) : article.autor != null) return false;
        return category == article.category;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", autor=" + autor +
                ", category=" + category +
                '}';
    }
}
///--------------------------------------------------------------------

class Autor
{
    String name;
    private int age;
    

    public Autor(String name) {
        this.name = name;
        
    }

    public int getAge() {
        return age;
    }

    public Autor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Autor autor = (Autor) o;

        return name != null ? name.equals(autor.name) : autor.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Developer
{
    private String name;
    private int age;
    private int salary;
    private  String pos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Developer(String name, int age, int salary, String pos) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pos = pos;
    }

    public Developer(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pos='" + pos + '\'' +
                '}';
    }
}