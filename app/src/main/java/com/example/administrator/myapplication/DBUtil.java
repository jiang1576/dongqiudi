package com.example.administrator.myapplication;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBUtil {
    private ArrayList<String> arrayList = new ArrayList<String>();
    private ArrayList<String> brrayList = new ArrayList<String>();
    private ArrayList<String> crrayList = new ArrayList<String>();
    private HttpConnSoap Soap = new HttpConnSoap();

    public static Connection getConnection() {
        Connection con = null;
        try {
            //Class.forName("org.gjt.mm.mysql.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://192.168.0.106:3306/test?useUnicode=true&characterEncoding=UTF-8","root","initial");
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return con;
    }

    /**
     * 获取所有货物的信息
     *
     * @return
     */
    public List<HashMap<String, String>> getAllInfo() {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        arrayList.clear();
        brrayList.clear();
        crrayList.clear();
        System.out.println(6);
        crrayList = Soap.GetWebServre ("selectAllCargoInfor", arrayList, brrayList);
        System.out.println(66666);
        System.out.println(crrayList);
        HashMap<String, String> tempHash = new HashMap<String, String>();
        tempHash.put("订单编号", "订单编号");
        tempHash.put("场地类型", "场地类型");
        tempHash.put("预约时间", "预约时间");
        tempHash.put("用户名", "用户名");
        list.add(tempHash);
        for (int j = 0; j < crrayList.size(); j +=4) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("订单编号", crrayList.get(j));
            hashMap.put("场地类型", crrayList.get(j + 1));
            hashMap.put("预约时间", crrayList.get(j + 2));
            hashMap.put("用户名", crrayList.get(j + 3));
            list.add(hashMap);
            System.out.println(list);
        }
        return list;
    }

    /**
     * 增加一条货物信息
     *
     * @return
     */
    public void insertCargoInfo(String Cno,String Cname, String Cnum,String name) {
        arrayList.clear();
        brrayList.clear();
        arrayList.add("Cno");
        arrayList.add("Cname");
        arrayList.add("Cnum");
        arrayList.add("name");
        brrayList.add(Cno);
        brrayList.add(Cname);
        brrayList.add(Cnum);
        brrayList.add(name);
        Soap.GetWebServre("insertCargoInfo", arrayList, brrayList);
    }



    public void updateCargoInfo(String Cno,String Cname, String Cnum) {
        arrayList.clear();
        brrayList.clear();
        arrayList.add("Cno");
        arrayList.add("Cname");
        arrayList.add("Cnum");
        brrayList.add(Cno);
        brrayList.add(Cname);
        brrayList.add(Cnum);
        Soap.GetWebServre("updateCargoInfo", arrayList, brrayList);
    }

    /**
     * 删除一条货物信息
     *
     * @return
     */
    public void deleteCargoInfo(String Cno) {

        arrayList.clear();
        brrayList.clear();

        arrayList.add("Cno");
        brrayList.add(Cno);

        Soap.GetWebServre("deleteCargoInfo", arrayList, brrayList);
    }
}
