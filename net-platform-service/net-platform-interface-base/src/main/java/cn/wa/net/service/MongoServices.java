package cn.wa.net.service;

import java.io.File;
import java.util.Map;

/**
 * Created by liupd on 16-4-15.
 **/

public interface MongoServices {

    /**
     * 文件保存到mongodb
     * @param resource
     * @return
     */
    public String saveFileResource(File resource);

    /**
     * 文件更新到mongodb
     * @param fileId
     * @param resource
     * @return
     */
    public String updateFileResource(String fileId, File resource);

    /**
     * 文件从mongodb删除
     * @param fileId
     * @return
     */
    public boolean delFileResource(String fileId);

    /**
     * 文件从mongodb查找
     * @param resFileId
     * @return
     */
    public String getFileIdByResId(String resFileId);

    /**
     * 获取资源文件信息
     * @param resFileId
     * @return
     */
    public Map<String,Object> getFileInfo(String resFileId);

    /**
     * outfile必须是存在的
     * @param resId
     * @param outfile
     * @return
     */
    public boolean getResFileById(String resId, File outfile) ;


}
