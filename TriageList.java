public class TriageList {

    /**
     * This should be your only instance variable
     */
    Node head = null;

    
    /**
    * Adds a Node/patient to the list by priority. 
    * Priorities are from 1 to 3 with 1 being the 
    * highest priority. Patients are placed in the 
    * list first by priority with 1 being the top 
    * of the list. If there are other patients with
    * the same priority already in the list, then 
    * the patient is placed at the end of that 
    * priority group.
    */
    public void addPatient(String name, int priority) {
        // make new patient 
        Node patient = new Node(name, priority);

        // if list is empty, add patient in the first place
        if (head == null) {
            patient.next = head;
            head = patient;
            return;
        }

        Node current = head;

        // if patient's priority is greater than head, add patient ahead 
        if (patient.priority < current.priority) {
            patient.next = current;
            head = patient;
            return;
        }

        while (current.next != null) {
			// if patient's priority# is greater than current & current.next == null, 
			if (patient.priority > current.priority && current.next == null) {
				current.next = patient;
				return;
			}
            // if patient's priority# is greater than current & less than current.next, add patient between them
            if (patient.priority > current.priority && patient.priority < current.next.priority ) {
                patient.next = current.next;
                current.next = patient;
                return;
            }
			// if patient's priority# equals to current and current.next.priority is greater than patient's
			if (patient.priority == current.priority && patient.priority < current.next.priority) {
				patient.next = current.next;
				current.next = patient;
				return;
			}

            current = current.next;
        }

        // if name is in the last order
        current.next = patient;
        patient.next = null;

    }

    /**
    * Removes and returns the name at the head of 
    * the list. Returns "No patients" if the list 
    * is empty.
    */
    public String treatNextPatient() {
        if (head == null) {
            return "No patients";
        }

        String firstPatient = head.name;
        head = head.next;
        
        return firstPatient;
    }

    /**
    * Returns the priority of the given name in 
    * the list. If the name does not exist then 
    * -1 is returned. 
    */
    public int contains(String name) {
		Node current = head;

        while (current != null) {
            if (name.equals(current.name)) {
				return current.priority;
			}

            current = current.next;
        }

		return -1;
    }

    /**
    * Returns a string containing the number of 
    * patients in each priority. For example. 
    * P1:3, P2:1, P3:2
    */
    public String triageCount() {
		if (head == null) {
			return "P1:0, P2:0, P3:0";
		}

		int p1 = 0, p2 = 0, p3 = 0;

		Node current = head;

		while (current != null) {
			if (current.priority == 1) {
				p1++;
			}
			if (current.priority == 2) {
				p2++;
			}
			if (current.priority == 3) {
				p3++;
			}

			current = current.next;
		}
        
		return "P1:" + p1 + ", P2:" + p2 + ", P3:" + p3;
    }
    
    public String toString(){
		if (head == null) {
			return "[]";
		}

		String text = "[" + head;

		Node current = head.next;
		while (current != null) {
			text += ", " + current;

			current = current.next;
		}

		text += "]";

		return text;
    }
}

// Do not modify the Node class
class Node {

    String name;
    int priority;
    Node next;

    public Node(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.next = null;
    }

    public Node(String name, int priority, Node next) {
        this.name = name;
        this.priority = priority;
        this.next = next;
    }

    public String toString() {
        return priority + "-" + name;
    }
}
