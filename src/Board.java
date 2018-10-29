import java.util.LinkedList;
import java.util.Objects;

public class Board {

    private LinkedList<Disk>Disklist1=new LinkedList<>();
    private LinkedList<Disk>Disklist2=new LinkedList<>();
    private LinkedList<Disk>Disklist3=new LinkedList<>();



    public void add(Disk disk){
        Disklist1.addFirst(disk);
    }


    public LinkedList<Disk> getDisklist1() {
        return Disklist1;
    }

    public LinkedList<Disk> getDisklist2() {
        return Disklist2;
    }

    public LinkedList<Disk> getDisklist3() {
        return Disklist3;
    }


    public boolean isBigger12(){
        if(Disklist2.size()==0){
            return true;
        }
        else {
            int size1 = Disklist1.getFirst().getSize();
            int size2 = Disklist2.getFirst().getSize();
            if (size1 < size2) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isBigger21(){
        if(Disklist1.size()==0){
            return true;
        }
        int size1 = Disklist1.getFirst().getSize();
        int size2 = Disklist2.getFirst().getSize();
        if (size1>size2){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBigger13(){
        if(Disklist3.size()==0){
            return true;
        }
        int size1 = Disklist1.getFirst().getSize();
        int size3 = Disklist3.getFirst().getSize();
        if (size1<size3){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBigger31(){
        if(Disklist1.size()==0){
            return true;
        }
        int size1 = Disklist1.getFirst().getSize();
        int size3 = Disklist3.getFirst().getSize();
        if (size1>size3){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBigger23(){
        if(Disklist3.size()==0){
            return true;
        }
        int size2 = Disklist2.getFirst().getSize();
        int size3 = Disklist3.getFirst().getSize();
        if (size2<size3){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBigger32(){
        if(Disklist2.size()==0){
            return true;
        }
        int size2 = Disklist2.getFirst().getSize();
        int size3 = Disklist3.getFirst().getSize();
        if (size2>size3){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(Disklist1, board.Disklist1) &&
                Objects.equals(Disklist2, board.Disklist2) &&
                Objects.equals(Disklist3, board.Disklist3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Disklist1, Disklist2, Disklist3);
    }

    @Override
    public String toString() {

        StringBuilder disk1String = new StringBuilder();
        for (Disk disk : Disklist1) {
            disk1String.append(disk.getSize());
        }

        StringBuilder disk2String = new StringBuilder();
        for (Disk disk : Disklist2) {
            disk2String.append(disk.getSize());
        }

        StringBuilder disk3String = new StringBuilder();
        for (Disk disk : Disklist3) {
            disk3String.append(disk.getSize());
        }


        return "Board{" +
                " " + disk1String +
                ", " + disk2String +
                ", " + disk3String +
                '}';
    }
}
