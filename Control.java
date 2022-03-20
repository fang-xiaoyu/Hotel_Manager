package hotel;
public class Control {
    private Room[][] allRooms;
    private int tall;
    private int depth;

    /**
     *
     * @param tall     <5
     * @param depth    <8
     */
    public Control(int tall, int depth) {
        allRooms = new Room[tall][depth];
        for (int t = 1; t < tall; t++) {
            for (int d = 1; d<=depth; d++) {
                allRooms[t-1][d-1] = new StandardRoom(Integer.parseInt(t +"0" + d));
            }
        }
        for (int d = 1; d<=depth; d++) {
            allRooms[tall-1][d-1] = new LuxRoom(Integer.parseInt((tall) +"0" + d));
        }
        this.tall = tall;
        this.depth = depth;
    }

    public void book(int roomNo) {
        int t = roomNo / 100;
        int d = roomNo % 100;
        allRooms[t-1][d-1].preserve();
    }

    public void checkOut(int roomNo) {
        int t = roomNo / 100;
        int d = roomNo % 100;
        allRooms[t-1][d-1].leave();
    }

    public void seeAllRooms() {
        for(int t = 1; t <= tall; t++) {
            for (int d = 1; d <= depth; d++) {
                System.out.println("房间号：" + allRooms[t-1][d-1].roomNo + " 房间类型：" + allRooms[t-1][d-1].roomType + " 房间状态：" + (allRooms[t-1][d-1].isPreserve==true?"可预订":"不可预订"));
            }
        }
    }

    public static void main(String[] args) {
        Control hotel = new Control(2, 3);
        hotel.seeAllRooms();
        System.out.println();
        hotel.book(202);
        System.out.println();
        hotel.book(202);
        System.out.println();
        hotel.checkOut(102);
        System.out.println();
        hotel.checkOut(202);
        System.out.println();
        hotel.book(203);
        System.out.println();
        hotel.seeAllRooms();
    }
}
