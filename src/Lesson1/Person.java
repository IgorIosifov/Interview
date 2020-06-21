package Lesson1;


class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public static class PersonBuilder {
        private Person person;

        public PersonBuilder() {
            person = new Person();
        }

        public PersonBuilder addFirstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public PersonBuilder addLastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public PersonBuilder addMiddleName(String middleName) {
            person.middleName = middleName;
            return this;
        }

        public PersonBuilder addCountry(String country) {
            person.country = country;
            return this;
        }

        public PersonBuilder addAddress(String address) {
            person.address = address;
            return this;
        }

        public PersonBuilder addPhone(String phone) {
            person.phone = phone;
            return this;
        }

        public PersonBuilder addAge(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder addGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public static void main(String[] args) {
        Shape a = new Triangle();
        Shape b = new Rectangle();
        Shape c = new Round();
        a.draw();
        b.draw();
        c.draw();
    }
}