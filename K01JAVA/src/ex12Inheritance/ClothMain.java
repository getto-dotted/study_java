package ex12Inheritance;


class Cloth {
    private String owner;
    
    public Cloth(String name) {
   	 this.owner = name;
   	 
    }
    public void wear() {
   	 System.out.println("옷을 입는다.");
    }
    public void takeOff() {
   	 System.out.println("옷을 벗는다.");
    }
    
}

class WinterCloth extends Cloth{
    private String season;
   	 
    public WinterCloth(String name, String season) {
   	 super(name);
   	 this.season = season;
    }
    @Override
    public void wear() {
   	 System.out.println("옷을 두껍게 입는다.");
    }
    @Override
    public void takeOff() {
   	 System.out.println("옷을 하나씩 벗는다.");
    }

}

class Jumper extends WinterCloth{
    private String brand;
    
    public Jumper(String name, String season, String brand) {
   	 super(name, season);
   	 this.brand = brand;
    }
    @Override
    public void wear() {
   	 System.out.println("지퍼를 잠근다.");
    }
    @Override
    public void takeOff() {
   	 System.out.println("지퍼를 푼다.");
    }
    
}

public class ClothMain {
    
    public static void wearing(Cloth a) {
   	 if(a instanceof Jumper) {
   		 ((Jumper)a).wear();
   	 }
   	 else if (a instanceof WinterCloth) {
   		 ((WinterCloth)a).wear();
   	 }
   	 else if (a instanceof Cloth) {
   		 a.wear();
   	 }
    }
    
    public static void takeOff(Cloth b) {
   	 if(b instanceof Jumper) {
   		 ((Jumper)b).wear();
   	 }
   	 else if (b instanceof WinterCloth) {
   		 ((WinterCloth)b).wear();
   	 }
   	 else if (b instanceof Cloth) {
   		 b.wear();
   	 }
    }

    public static void main(String[] args) {
    
   	 Cloth cloth1 = new Cloth("옷");
   	 WinterCloth cloth2 = new WinterCloth("옷", "겨울");
   	 Jumper cloth3 = new Jumper("옷", "겨울", "노스페이스");
   	 
   	 cloth1.wear();
   	 cloth2.wear();   	 
   	 cloth3.wear();   	 
   	 
   	 cloth1.takeOff();
   	 cloth2.takeOff();
   	 cloth3.takeOff();

    }

}
