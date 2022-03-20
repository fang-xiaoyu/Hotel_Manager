package hotel;

public class Room {
    int roomNo;
    String roomType;
    boolean isPreserve;

    public Room(int roomNo) {
        this.roomNo = roomNo;
        isPreserve = true;
    }

    public void preserve() {
        if (!isPreserve) {
            System.out.println("对不起，当前房间已被预订。");
            return;
        }
        isPreserve = false;
        System.out.println("房间预订成功！");
    }

    public void leave() {
        if (isPreserve){
            System.out.println("对不起，当前房间未被预订，不能退房。");
            return;
        }
        isPreserve = true;
        System.out.println("退房成功！");
    }

    public boolean getIsPreserved() {
        return isPreserve;
    }
}
