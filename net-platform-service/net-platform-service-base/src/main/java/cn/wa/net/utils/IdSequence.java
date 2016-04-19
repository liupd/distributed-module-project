package cn.wa.net.utils;

import com.baomidou.mybatisplus.toolkit.IdWorker;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 如果是用在集群环境，需要在前面加上机器的编号，或者IP。直接调用getId 函数
 * 如192.168.1.1
 * 如 1921680002121447290788120001
 * 非集群环境直接调用nextId 函数即可 如 1447290788110996
 */
public class IdSequence {
    /**
     * 生成id序列的位数
     */
    private static int idLength = 16;//建议最少15位    低于15位则有可能出现重复
    private static long ONE_STEP = 0;
    private static final Lock LOCK = new ReentrantLock();
    private static long lastTime = System.currentTimeMillis();
    private static short lastCount = 0;
    private static int count = 0;
    private static String format = "";

    private static String localIp = "";

    static {
        int ln = idLength - 13;
        StringBuffer sb = new StringBuffer();
        sb.append(1);
        for (int i = 0; i < ln; i++) {
            sb.append(0);
        }
        System.out.println(sb.toString());

        ONE_STEP = Long.parseLong(sb.toString());
        format = "%0" + (idLength - 13) + "d";
    }

    /**
     * 业务系统为单机使用时或操作高并发几率比较小  可以使用此方法生成id
     *
     * @return
     */
    @SuppressWarnings("finally")
    public static String nextId() {
        return String.valueOf(IdWorker.getId());
    }

    /**
     * 如果业务系统为分布式部署，并发率比较高则采用次方法生成id
     * id为ip地址+时间(ms)+序列
     *
     * @return
     */
    public static String getId() {
        StringBuffer sb = new StringBuffer();
        sb.append(getLocalIp());
        sb.append(nextId());
        return sb.toString();
    }

    public static String getLocalIp() {
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isEmpty(localIp)) {
            String localAddress = getIp();
            if (localAddress.length() < 7) {
                localIp = "";
            } else {
                String str[] = localAddress.split("\\.");
                for (String s : str) {
                    if (s.length() < 3) {
                        for (int i = 0; i < 3 - s.length(); i++) {
                            sb.append(0);
                        }
                    }
                    sb.append(s);
                }
                localIp = sb.toString();
            }

        }
        return localIp;
    }


    public static void main(String[] args) {
        //测试
        Long start = System.currentTimeMillis();
        System.out.println(start.toString().length());
        for (int i = 0; i < 10000; i++) {
            System.out.println(nextId());
//            System.out.println(getUniqueId());
        }
        System.out.println(nextId().toString().length());
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(UUID.randomUUID().toString().length());
        System.out.println(getId());
    }

    public static String getIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}