package javapractice.optionals;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;


import static org.junit.Assert.*;

public class OptionalExamples {
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "baeldung";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Bishal");
        opt.ifPresent(name -> System.out.println(name.length()));
        System.out.println(opt.get());

    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("Bishal");
        assertEquals("Bishal", name);
    }

    @Test
    public void orElseGet_example() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(()->"Bishal");
        assertEquals("Bishal", name);
    }

    public String getDefaultValue() {
        System.out.println("Getting Default value");
        return "Default Value";
    }

    @Test
    public void orElse_orElseGet_comparision_null() {
        String text = null;
        String defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
        assertEquals("Default Value", defaultText);
    }

    @Test
    public void orElse_orElseGet_comparision() {
        String text = "Text";
        String defaultText = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        assertEquals("Text", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getDefaultValue());
        assertEquals("Text", defaultText);
    }

    @Test
    public void orElseThrows_example() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalAccessError::new);
    }

    @Test
    public void get_optional_Example() {
        Optional<String> opt = Optional.of("Bishal");
        String name = opt.get();
        assertEquals("Bishal", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void getWithNull_Example() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
    }

    @Test
    public void optionalFilter_example() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y->y==2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y->y==2017).isPresent();
        assertFalse(is2017);
    }

    @Test
    public void map_flatmap_comparison() {
        Person person = new Person("Bishal", 26);
        Optional<Person> personOptional = Optional.of(person);
        String nameOptionalWrapper = personOptional.map(Person::getName).orElseThrow(IllegalAccessError::new).orElse("");
        assertEquals("Bishal", nameOptionalWrapper);

        String name = personOptional.flatMap(Person::getName).orElse("");
        assertEquals("Bishal", name);
    }


    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if(input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

    @Test
    public void Optional_streamAPI_example() {
        Optional<String> found = Stream.of(getEmpty(),getHello(), getBye()).
                filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
        assertEquals(getHello(), found);
    }

    @Test
    public void Optional_streamAPI_supplier_example() {
        //Stream map is the intermediate operation which allows lazy processing. Intermediate operation is invoked on a Stream instance and after entore processing isover, then it goes to next.
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(this::getBye, this::getEmpty, this::getHello)
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }
}
