package tw.com.jersey.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * MyApplicationBinder
 * 
 * @author chrisryo
 *
 */
public class MyApplicationValid {

  private String root = null;

  public MyApplicationValid() {
    System.out.println("5456456");
  }

  /**
   * 根据传过来的路径，文件名称，文件内容生成JS文件
   * 
   * @param path
   * @param name
   * @param html
   * @throws IOException
   * @throws DefaultException
   */
  private void writeJS(String path, String name, String html) throws IOException {
    /* 创建目录 */
    File filePath = createDir(root, path.trim());
    /* 创建文件 */
    File file = getFile(filePath, name.trim() + ".js");
    /* 写文件 */
    writeFile(file, html);
  }


  /**
   * 创建目录，目录必须以"/"间隔
   * 
   * @param rootPath
   * @param path
   * @throws IOException
   * @throws DefaultException
   */
  private File createDir(String rootPath, String path) throws IOException {

    File file = new File(rootPath);
    if (!file.exists()) {
      throw new IOException("根目录不存在");
    }

    String dirs[] = path.split("/");
    for (int i = 0; i < dirs.length; i++) {
      if (dirs[i] != null && !"".equals(dirs[i].trim())) {
        file = getDir(file, dirs[i]);
      }
    }
    return file;
  }

  /**
   * 创建目录
   * 
   * @param parentPath
   * @param dirName
   * @return
   * @throws IOException
   */
  private File getDir(File parentPath, String dirName) throws IOException {
    File dir = new File(parentPath, dirName);
    if (!dir.exists()) {
      dir.mkdir();
    }
    return dir;
  }

  /**
   * 创建文件
   * 
   * @param dirPath
   * @param fileName
   * @return
   * @throws IOException
   */
  private File getFile(File dirPath, String fileName) throws IOException {
    File file = new File(dirPath, fileName);
    if (!file.exists()) {
      file.createNewFile();
    }
    return file;
  }

  /**
   * 写文件
   * 
   * @param file
   * @param html
   * @throws IOException
   * @throws DefaultException
   */
  private void writeFile(File file, String html) throws IOException {

    if (html != null && !"".equals(html.trim())) {
      /* 参数有效性检测 */
      if (file == null || !file.isFile()) {
        throw new IOException("public static void appendFile(File tar) parameters error!");
      }
      /* 判断文件是否可写 */
      if (!file.canWrite()) {
        throw new IOException(file.toString() + " write prohibited! ");
      }
      String js = "var html =\"" + html + "\";document.write(html);";
      /* 写文件 */
      /*
       * FileWriter fw = new FileWriter(file); fw.write(js); fw.close();
       */
      OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "GBK");
      out.write(js.toString());
      out.flush();
      out.close();
    } else {
      /* 参数有效性检测 */
      if (file == null || !file.isFile()) {
        throw new IOException("public static void appendFile(File tar) parameters error!");
      }
      /* 判断文件是否可写 */
      if (!file.canWrite()) {
        throw new IOException(file.toString() + " write prohibited! ");
      }
      String js = "var html =\"\";document.write(html);";
      /* 写文件 */
      /*
       * FileWriter fw = new FileWriter(file); fw.write(js); fw.close();
       */
      OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "GBK");
      out.write(js.toString());
      out.flush();
      out.close();
    }
  }
}
