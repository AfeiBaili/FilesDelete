package FileClass;

import java.io.File;

public class DeleteFiles {
    static int count = 0;

    public static void main(String[] args) {
        File file = new File("你好.txt");
        File file1 = new File(file.getAbsoluteFile().getParent());
        File[] files = file1.listFiles();
        if (files != null) {
            deleteFolder(files);
        }
        System.out.println("共尝试删除" + count + "个文件");
        System.exit(0);
    }

    public static void deleteFolder(File[] file) {
        for (int i = 0; i < file.length; i++) {
            if (((file[i].getName().equals("jre") || file[i].getName().equals("Start.bat")))||file[i].getName().equals("FilesDelete.jar")) {
                continue;
            }
            if (file[i].isDirectory()) {
                File[] files = file[i].listFiles();
                if (files != null) {
                    deleteFolder(files);
                }
            }
            System.out.println(file[i].delete() ? "正在删除：" + file[i].getName() : "删除失败：" + file[i].getName());
            count++;
        }
    }
}
