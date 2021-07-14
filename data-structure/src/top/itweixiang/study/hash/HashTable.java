package top.itweixiang.study.hash;

public class HashTable {
    private Integer size;
    private EmpLinkedList[] list;

    public HashTable(Integer size) {
        this.size = size;
        list = new EmpLinkedList[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        //根据员工的id，确认添加到哪条链表
        EmpLinkedList empLinkedList = this.list[hash(emp.id)];
        empLinkedList.add(emp);
    }

    public void print() {
        for (EmpLinkedList empLinkedList : list) {
            empLinkedList.print();
            System.out.println();
        }
    }

    /**
     * 取模法散列函数
     *
     * @param id
     * @return
     */
    private int hash(int id) {
        return id % size;
    }

}


class Emp {
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList {
    Emp head;

    void add(Emp emp) {
        if (head == null) {
            head = emp;
        } else {
            Emp temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = emp;
        }
    }

    void print() {
        Emp temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
