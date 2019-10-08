public class subway {
    public static void main(String[] args) {
        if (args.length >= 1 && args[0].compareTo("-help") == 0) {
            System.out.println("用法 java subway [-options]");
            System.out.println("\t\t(地铁路线规划程序)");
            System.out.println("其中选项包括：");
            System.out.println("\t-map <地铁信息文件>\n\t\t\t指定地铁信息文件（必须项）");
            System.out.println("\t-o <输出文件>\t指定输出文件（若不指定则输出控制台）");
            System.out.println("\t-a <指定地铁线路>\n\t\t\t指定地铁线路输出");
            System.out.println("\t-b <起点站> <目的站>\n\t\t\t指定起点站与终点站，规划规划路线");
            System.out.println("\t\t(-a，-b 仅能选择其一，若两者都无，则输出所有线路地铁)");
            System.out.println("\t-help\t\t查看帮助信息（单独使用）");
            System.out.println("Powered by shy!");
            return;
        }
        Main.main(args);
    }
}
