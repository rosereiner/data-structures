package lab3;

/**
* This class represents a name of a person.
*
* For Lab 3, students are provided with the skeleton of this class.
* Student must complete all methods, as indicated in this code.
* Students may only add code where indicated. The data members and method
* declarations should not be altered.
*
* @author Rose Reiner. Collaborated with Winnie Chien and Kinser Bonner
* @version 1.0
*/
public class PersonName {
        /** The person's first name */
        private String firstName;

        /** The person's middle name. null if person has no middle name */
        private String middleName;

        /** The person's last name */
        private String lastName;

        /**
        * Parameterized constructor. Initializes data members to the
        * parameter values.
        *
        * @param f The person's first name
        * @param m The person's middle name
        * @param l The person's last name
        */
        public PersonName(String f, String m, String l) {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	setFirstName(f);
        	setMiddleName(m);
        	setLastName(l);
        }

        /**
        * Default constructor. Initialzes data members to default values
        */
        public PersonName() {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	this("", null, "");
        }
        //Creating another method for the new Array, so it won't change the string name of the authors in tb1
        public PersonName(PersonName a){
        	setFirstName(a.getFirstName());
        	setMiddleName(a.getMiddleName());
        	setLastName(a.getLastName());
        }

        /**
        * Retrieves the person's first name
        *
        * @return The person's first name
        */
        public String getFirstName() {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	return this.firstName;
        }

        /**
        * Retrieves the person's middle name
        *
        * @return The person's middle name
        */
        public String getMiddleName() {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	return this.middleName;
        }

        /**
        * Retrieves the person's last name
        *
        * @return The person's last name
        */
        public String getLastName() {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	return this.lastName;
        }

        /**
        * Sets the person's first name
        *
        * @param f The person's first name
        */
        public void setFirstName(String f) {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	if(f == null){
        		f = "";
        	}
        	firstName = f;
        }

        /**
        * Sets the person's middle name
        *
        * @param m The person's middle name
        */
        public void setMiddleName(String m) {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	if (m == null){
        		m = "";
        	}
        	middleName = m;
        }

        /**
        * Sets the person's last name
        *
        * @param l The person's last name
        */
        public void setLastName(String l) {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	if (l == null){
        		l = "";
        	}
        	lastName = l;
        }

        /**
        * Returns a string representation of this PersonName object.
        * If the middle name is null, does not include the middle name.
        *
        * @return A string representation of this PersonName object.
        */
        public String toString() {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	
        	if(firstName == "" && lastName == ""){
        		return "";
        	}
        	
        	if(!middleName.equals("")){
        		return firstName + " " + middleName + " " + lastName; 
        	
        	}else{
        		return firstName + " " + lastName;
        	}
        }
       

        /**
        * Returns true if the parameter object is equal to this PersonName
        * object. Equality is defined as having the same values for every
        * data member.
        *
        * @param obj The object to compare this object with
        * @return True if the two objects are the same
        */
        public boolean equals(Object obj) {
            /**** STUDENT MUST COMPLETE THIS METHOD ****/
        	if(obj instanceof PersonName){
        		PersonName c = (PersonName)obj;

        	if(firstName.equals(c.getFirstName()) && middleName.equals(c.getMiddleName()) 
        			&&  lastName.equals(c.getLastName())){	
        		return true;
        	}else{
        		return false;
        	}
        }else{
        	return false;
        }
        	
        	
}
}