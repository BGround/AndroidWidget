#RecyclerView的线性，网格，和瀑布流
线性：setList
网格：GridView
瀑布：WaterFall

单击和长按操作
OnClickListener
OnLongClickListener

添加删除操作
recyclerview删除时数组越界??

    java.lang.ArrayIndexOutOfBoundsException: length=12; index=-1
        at java.util.ArrayList.remove(ArrayList.java:405)
        at com.example.recycleview.adapter.HomeAdapter.removeData(HomeAdapter.java:35)
        at com.example.recycleview.MainActivity$1$1.onClick(MainActivity.java:90)
        at android.support.v7.app.AlertController$ButtonHandler.handleMessage(AlertController.java:167)
        at android.os.Handler.dispatchMessage(Handler.java:102)
        at android.os.Looper.loop(Looper.java:157)
        at android.app.ActivityThread.main(ActivityThread.java:5653)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:746)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:636)