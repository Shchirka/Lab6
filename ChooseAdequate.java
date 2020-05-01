package Lab6;

public class ChooseAdequate {
    public  static double[][] mini_kohren = {{9985, 9750, 9392, 9057, 8772},
            {9669, 8709, 7977, 7457, 7071},
            {9065, 7679, 6841, 6287, 5892},
            {8412, 6838, 5981, 5440, 5063},
            {7808, 6161, 5321, 4803, 4447},
            {7271, 5612, 4800, 4307, 3974},
            {6798, 5157, 4377, 3910, 3595},
            {6385, 4775, 4027, 3584, 3586},
            {6020, 4450, 3733, 3311, 3029},
            {5410, 3924, 3264, 2880, 2624},
            {5410, 3924, 3264, 2880, 2624},
            {5410, 3924, 3264, 2880, 2624},
            {5410, 3924, 3264, 2880, 2624},
            {4709, 3346, 2758, 2419, 2159},
            {4709, 3346, 2758, 2419, 2159}};

    public static double[] mini_student = {12.71, 4.303, 3.182, 2.776, 2.571, 2.447, 2.365, 2.306, 2.262, 2.228,
            2.201, 2.179, 2.16, 2.145, 2.131, 2.12, 2.11, 2.101, 2.093, 2.086, 2.08, 2.08, 2.074, 2.074, 2.074, 2.069, 2.064, 2.06, 2.05, 2.042,
            2.041, 2.04, 2.038, 2.036, 2.035, 2.031, 2.03, 2.028, 2.025, 2.021, 2.02, 2.019, 2.018, 2.17, 2.016, 2.015, 2.014, 2.013, 2.012, 2.011, 2.01};

    public static double[][] mini_fisher = {{164.4, 199.5, 215.7, 224.6, 230.2, 234.0, 244.9},
            {18.5, 19.2, 19.2, 19.3, 19.3, 19.3, 19.4},
            {10.1, 9.6, 9.3, 9.1, 9.0, 8.9, 8.7},
            {7.7, 6.9, 6.6, 6.4, 6.3, 6.2, 5.9},
            {6.6, 5.8, 5.4, 5.2, 5.1, 5.0, 4.7},
            {6.0, 5.1, 4.8, 4.5, 4.4, 4.3, 4.0},
            {5.5, 4.7, 4.4, 4.1, 4.0, 3.9, 3.6},
            {5.3, 4.5, 4.1, 3.8, 3.7, 3.6, 3.3},
            {5.1, 4.3, 3.9, 3.6, 3.5, 3.4, 3.1},
            {5.0, 4.1, 3.7, 3.5, 3.3, 3.2, 2.9},
            {4.8, 4.0, 3.6, 3.4, 3.2, 3.1, 2.8},
            {4.8, 3.9, 3.5, 3.3, 3.1, 3.0, 2.7},
            {4.7, 3.8, 3.4, 3.2, 3.0, 2.9, 2.6},
            {4.6, 3.7, 3.3, 3.1, 3.0, 2.9, 2.5},
            {4.5, 3.7, 3.3, 3.1, 2.9, 2.8, 2.5},
            {4.5, 3.6, 3.2, 3.0, 2.9, 2.7, 2.4},
            {4.5, 3.6, 3.2, 3.0, 2.8, 2.7, 2.4},
            {4.4, 3.6, 3.2, 2.9, 2.8, 2.7, 2.3},
            {4.4, 3.5, 3.1, 2.9, 2.7, 2.6, 2.3},
            {4.4, 3.5, 3.1, 2.9, 2.7, 2.6, 2.3},
            {4.3, 3.4, 3.1, 2.8, 2.7, 2.6, 2.2},
            {4.3, 3.4, 3.0, 2.8, 2.6, 2.5, 2.2}};

    public static void main(String[] args) {
        int x1min = -15, x1max = 30, x2min = -20, x2max = 40, x3min = -15, x3max = -5;
        /*double ymax = 200 + (x1max + x2max + x3max)/3;
        double ymin = 200 + (x1min + x2min + x3min)/3;*/
        double l = 1.73;
        int[][] array_x = new int[8][3]; // матриця факторів
        int n = array_x.length;
        double[][] array_xn = new double[array_x.length][7]; // матриця нормованих факторів
        double[] x0 = new double[array_x[0].length];
        double[] dx = new double[x0.length];
        double[][] array_xn_9_15 = new double[7][10];
        double[][] array_x_9_15 = new double[7][10];
        int m = 2; // кількість провведених експериментів
        int d = 0;
        double q = 0.05; // рівень значимості
        double fp; //експериментальний критерій Фішера
        double y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0, y6 = 0, y7= 0, y8 = 0, y9= 0, y10= 0, y11= 0, y12 = 0, y13 = 0, y14 = 0, y15 = 0; // середні значення функцій відгуку в рядках

        double b0, b1, b2, b3, b12, b13, b23, b123; // коефіцієнти рівняння регресії

        array_x[0][0] = x1min; array_x[1][0] = x1min; array_x[2][0] = x1min; array_x[3][0] = x1min;
        array_x[4][0] = x1max; array_x[5][0] = x1max; array_x[6][0] = x1max; array_x[7][0] = x1max;
        array_x[0][1] = x2min; array_x[1][1] = x2min; array_x[2][1] = x2max; array_x[3][1] = x2max;
        array_x[4][1] = x2min; array_x[5][1] = x2min; array_x[6][1] = x2max; array_x[7][1] = x2max;
        array_x[0][2] = x3min; array_x[1][2] = x3max; array_x[2][2] = x3min; array_x[3][2] = x3max;
        array_x[4][2] = x3min; array_x[5][2] = x3max; array_x[6][2] = x3min; array_x[7][2] = x3max;

        array_xn_9_15[0][0] = -l; array_xn_9_15[1][0] = l; array_xn_9_15[2][0] = array_xn_9_15[2][0] = array_xn_9_15[3][0] = array_xn_9_15[4][0] =
                array_xn_9_15[5][0] = array_xn_9_15[6][0] = 0;
        array_xn_9_15[2][1] = -l; array_xn_9_15[3][1] = l; array_xn_9_15[0][1] = array_xn_9_15[1][1] = array_xn_9_15[4][1] = array_xn_9_15[5][1] =
                array_xn_9_15[6][1] = 0;
        array_xn_9_15[4][2] = -l; array_xn_9_15[5][2] = l; array_xn_9_15[2][2] =  array_xn_9_15[3][2] = array_xn_9_15[0][2] =
                array_xn_9_15[1][2] = array_xn_9_15[6][2] = 0;


        x0[0] = (double)(x1max + x1min)/2;
        dx[0] = x1max - x0[0];

        x0[1] = (double)(x2max + x2min)/2;
        dx[1] = x2max - x0[1];

        x0[2] = (double)(x3max + x3min)/2;
        dx[2] = x3max - x0[2];

        for (int i = 0; i < array_x.length; i++){
            for (int j = 0; j < array_x[i].length; j++){
                array_xn[i][j] = (array_x[i][j] - x0[j])/dx[j];
            }
        }

        for(int i = 0; i < array_xn.length; i++){
            array_xn[i][3] = array_xn[i][0]*array_xn[i][1];
            array_xn[i][4] = array_xn[i][0]*array_xn[i][2];
            array_xn[i][5] = array_xn[i][1]*array_xn[i][2];
            array_xn[i][6] = array_xn[i][0]*array_xn[i][1]*array_xn[i][2];
        }

        System.out.println("\nМатриця нормованих факторів:");
        for (int i = 0; i < array_xn.length; i++){
            for (int j = 0; j < array_xn[i].length; j++){
                double help = array_xn[i][j] * 1000;
                help = Math.round(help);
                System.out.print((help/1000) + "  ");

            }
            System.out.println();
        }
            double[][] array_y = new double[array_x.length][m]; // матриця функцій відгуку
            for (int i = 0; i < array_y.length; i++){
                for (int j = 0; j < array_y[i].length; j++){
                    array_y[i][j] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                    7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                    5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                    1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                }
            }
            System.out.println("\nМатриця функцій відгуку:");
            for (int i = 0; i < array_y.length; i++){
                for (int j = 0; j < array_y[i].length; j++){
                    System.out.print(array_y[i][j] + "  ");
                }
                System.out.println();
            }

            double exp_kohren = 0;
            double disp1 = 0, disp2 = 0, disp3 = 0, disp4 = 0, disp5 = 0, disp6 = 0, disp7 = 0, disp8 = 0;
            do {
                exp_kohren = 0;
                double[][] ex_array = new double[array_y.length][m];
                for (int i = 0; i < ex_array.length; i++){
                    for (int j = 0; j < array_y[i].length; j++){
                        ex_array[i][j] = array_y[i][j];
                    }
                }
                if(m > 2){
                    for(int i = 0; i < ex_array.length; i++){
                        ex_array[i][m-1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                    }
                }
                if(m > 3){
                    for(int i = 0; i < ex_array.length; i++){
                        ex_array[i][m-1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                    }
                }
                y1 = 0; y2 = 0; y3 = 0; y4 = 0; y5 = 0; y6 = 0; y7= 0; y8 = 0; y9= 0; y10= 0; y11= 0; y12 = 0; y13 = 0; y14 = 0; y15 = 0;
                for (int i = 0; i < array_y[0].length; i++){
                    y1 += ex_array[0][i];
                    y2 += ex_array[1][i];
                    y3 += ex_array[2][i];
                    y4 += ex_array[3][i];
                    y5 += ex_array[4][i];
                    y6 += ex_array[5][i];
                    y7 += ex_array[6][i];
                    y8 += ex_array[7][i];
                }
                y1 /= m;
                y2 /= m;
                y3 /= m;
                y4 /= m;
                y5 /= m;
                y6 /= m;
                y7 /= m;
                y8 /= m;
                double mx1 = 0, mx2 = 0, mx3 = 0;
                double my;
                double a1, a2, a3;
                double a11 = 0, a22 = 0, a33 = 0, a12 = 0, a13 = 0, a23 = 0;
                for (int i = 0; i < array_x.length; i++){
                    mx1 += array_x[i][0];
                    mx2 += array_x[i][1];
                    mx3 += array_x[i][2];
                    a11 += array_x[i][0]*array_x[i][0];
                    a22 += array_x[i][1]*array_x[i][1];
                    a33 += array_x[i][2]*array_x[i][2];
                    a12 += array_x[i][0]*array_x[i][1];
                    a13 += array_x[i][0]*array_x[i][2];
                    a23 += array_x[i][1]*array_x[i][2];
                }
                mx1 /= n;
                mx2 /= n;
                mx3 /= n;
                my = (y1 + y2 + y3 + y4 + y5 + y6 + y7 + y8)/n;
                a1 = (array_x[0][0]*y1 + array_x[1][0]*y2 + array_x[2][0]*y3 + array_x[3][0]*y4 + array_x[4][0]*y5 + array_x[5][0]*y6 + array_x[6][0]*y7 + array_x[7][0]*y8)/n;
                a2 = (array_x[0][1]*y1 + array_x[1][1]*y2 + array_x[2][1]*y3 + array_x[3][1]*y4 + array_x[4][1]*y5 + array_x[5][1]*y6 + array_x[6][1]*y7 + array_x[7][1]*y8)/n;
                a3 = (array_x[0][2]*y1 + array_x[1][2]*y2 + array_x[2][2]*y3 + array_x[3][2]*y4 + array_x[4][2]*y5 + array_x[5][2]*y6 + array_x[6][2]*y7 + array_x[7][2]*y8)/n;
                a11 /= n;
                a22 /= n;
                a33 /= n;
                a12 /= n;
                a13 /= n;
                a23 /= n;

                double[][] delta_0 = {{my, mx1, mx2, mx3}, {a1, a11, a12, a13}, {a2, a12, a22, a23}, {a3, a13, a23, a33}};
                double[][] delta_1 = {{1, my, mx2, mx3}, {mx1, a1, a12, a13}, {mx2, a2, a22, a23}, {mx3, a3, a23, a33}};
                double[][] delta_2 = {{1, mx1, my, mx3}, {mx1, a11, a1, a13}, {mx2, a12, a2, a23}, {mx3, a13, a3, a33}};
                double[][] delta_3 = {{1, mx1, mx2, my}, {mx1, a11, a12, a1}, {mx2, a12, a22, a2}, {mx3, a13, a23, a3}};
                double[][] delta = {{1, mx1, mx2, mx3}, {mx1, a11, a12, a13}, {mx2, a12, a22, a23}, {mx3, a13, a23, a33}};

                b0 = Delta(delta_0)/Delta(delta);
                b1 = Delta(delta_1)/Delta(delta);
                b2 = Delta(delta_2)/Delta(delta);
                b3 = Delta(delta_3)/Delta(delta);

                if(b1 < 0){
                    if(b2 < 0){
                        if(b3 < 0){
                            System.out.format("Рівняння регресії: %n y = %.1f %.1f x1 %.1f x2 %.1f x3", b0, b1, b2, b3);
                        }
                        else{
                            System.out.format("Рівняння регресії: %n y = %.1f %.1f x1 %.1f x2 + %.1f x3", b0, b1, b2, b3);
                        }
                    }
                    else if(b3 < 0){
                        System.out.format("Рівняння регресії: %n y = %.1f %.1f x1 + %.1f x2 %.1f x3", b0, b1, b2, b3);
                    }
                    else{
                        System.out.format("Рівняння регресії: %n y = %.1f %.1f x1 + %.1f x2 + %.1f x3", b0, b1, b2, b3);
                    }
                }
                else{
                    if(b2 < 0){
                        if(b3 < 0){
                            System.out.format("Рівняння регресії: %n y = %.1f + %.1f x1 %.1f x2 %.1f x3", b0, b1, b2, b3);
                        }
                        else{
                            System.out.format("Рівняння регресії: %n y = %.1f + %.1f x1 %.1f x2 + %.1f x3", b0, b1, b2, b3);
                        }
                    }
                    else if(b3 < 0){
                        System.out.format("Рівняння регресії: %n y = %.1f + %.1f x1 + %.1f x2 %.1f x3", b0, b1, b2, b3);
                    }
                    else{
                        System.out.format("Рівняння регресії: %n y = %.1f + %.1f x1 + %.1f x2 + %.1f x3", b0, b1, b2, b3);
                    }
                }

                System.out.println();


                disp1 = 0; disp2 = 0; disp3 = 0; disp4 = 0; disp5 = 0; disp6 = 0; disp7 = 0; disp8 = 0;
                for(int i = 0; i < ex_array[0].length; i++){
                    disp1 += Math.pow((ex_array[0][i] - y1), 2);
                    disp2 += Math.pow((ex_array[1][i] - y2), 2);
                    disp3 += Math.pow((ex_array[2][i] - y3), 2);
                    disp4 += Math.pow((ex_array[3][i] - y4), 2);
                    disp5 += Math.pow((ex_array[3][i] - y5), 2);
                    disp6 += Math.pow((ex_array[3][i] - y6), 2);
                    disp7 += Math.pow((ex_array[3][i] - y7), 2);
                    disp8 += Math.pow((ex_array[3][i] - y8), 2);
                }

                disp1 /= m;
                disp2 /= m;
                disp3 /= m;
                disp4 /= m;
                disp5 /= m;
                disp6 /= m;
                disp7 /= m;
                disp8 /= m;

                exp_kohren += (Math.max((Math.max((Math.max(disp1, disp2)), (Math.max(disp3, disp4)))),
                        (Math.max((Math.max(disp5, disp6)), (Math.max(disp7, disp8))))))/
                        (disp1 + disp2 + disp3 + disp4 + disp5 + disp6 + disp7 + disp8);

                m += 1;
            } while (exp_kohren > (mini_kohren[n-2][(m-2) - 1])/10000);
            m -= 1;

            System.out.println("Дисперсія однорідна при " + m + " дослідах");

            int sum_n = 0;
            for(int i = 1; i <= n; i++){
                sum_n += i;
            }

            double s = Math.sqrt((disp1 + disp2 + disp3 + disp4 + disp5 + disp6 + disp7 + disp8)/(n*sum_n*m));
            double beta0 = 0, beta1 = 0, beta2 = 0, beta3 = 0, beta12 = 0, beta23 = 0, beta13 = 0, beta123 = 0;
            double t0, t1, t2, t3, t12, t23, t13, t123, t_tabl;
            double[] array_mid_y = {y1, y2, y3, y4, y5, y6, y7, y8};

            for(int i = 0; i < n; i++){
                beta0 += array_mid_y[i]*1;
                beta1 += array_mid_y[i]*array_xn[i][0];
                beta2 += array_mid_y[i]*array_xn[i][1];
                beta3 += array_mid_y[i]*array_xn[i][2];
            }
            beta0 /= n;
            beta1 /= n;
            beta2 /= n;
            beta3 /= n;

            t0 = beta0/s;
            t1 = beta1/s;
            t2 = beta2/s;
            t3 = beta3/s;

            t_tabl = mini_student[(m-1)*n - 1];
            d = 0; // кількість значущих коефіцієнтів при рівні значимості q = 0.05
            if(t0 < t_tabl){
                System.out.println("b0 - незначний коефіцієнт => вилучається з рівняння");
                b0 = 0;
            }
            else{
                d += 1;
            }
            if(t1 < t_tabl){
                System.out.println("b1 - незначний коефіцієнт => вилучається з рівняння");
                b1 = 0;
            }
            else{
                d += 1;
            }
            if(t2 < t_tabl){
                System.out.println("b2 - незначний коефіцієнт => вилучається з рівняння");
                b2 = 0;
            }
            else{
                d += 1;
            }
            if(t3 < t_tabl){
                System.out.println("b3 - незначний коефіцієнт => вилучається з рівняння");
                b3 = 0;
            }
            else{
                d += 1;
            }


            double[] some_array_mid_y = new double[n];
            for(int i = 0; i < some_array_mid_y.length; i++){
                some_array_mid_y[i] = b0 + b1*array_x[i][0] + b2*array_x[i][1] + b3*array_x[i][2];
            }

            double s_ad = 0;
            for(int i = 0; i < n; i++){
                s_ad += Math.pow((some_array_mid_y[i] - array_mid_y[i]),2);
            }
            s_ad *= m;
            s_ad /= n-d;
            fp = (s_ad*n)/(disp1 + disp2 + disp3 + disp4);

            if(fp < mini_fisher[(m-1)*n - 1][n - d - 1]){
                System.out.println("Рівняння регресії адекватно оригіналу при рівні значимості " + q);
            }

            else {
                System.out.println("Рівняння регресії неадекватно оригіналу при рівні значимості " + q);
                b0 = 0;
                b1 = 0;
                b2 = 0;
                b3 = 0;
                b12 = 0;
                b23 = 0;
                b13 = 0;
                b123 = 0;

                do {
                    exp_kohren = 0;
                    double[][] ex_array = new double[array_y.length][m];
                    for (int i = 0; i < ex_array.length; i++) {
                        for (int j = 0; j < array_y[i].length; j++) {
                            ex_array[i][j] = array_y[i][j];
                        }
                    }
                    if (m > 2) {
                        for (int i = 0; i < ex_array.length; i++) {
                            ex_array[i][m - 1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                    7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                    5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                    1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                        }
                    }
                    y1 = 0; y2 = 0; y3 = 0; y4 = 0; y5 = 0; y6 = 0; y7= 0; y8 = 0; y9= 0; y10= 0; y11= 0; y12 = 0; y13 = 0; y14 = 0; y15 = 0;
                    for (int i = 0; i < array_y[0].length; i++) {
                        y1 += ex_array[0][i];
                        y2 += ex_array[1][i];
                        y3 += ex_array[2][i];
                        y4 += ex_array[3][i];
                        y5 += ex_array[4][i];
                        y6 += ex_array[5][i];
                        y7 += ex_array[6][i];
                        y8 += ex_array[7][i];
                    }
                    y1 /= m;
                    y2 /= m;
                    y3 /= m;
                    y4 /= m;
                    y5 /= m;
                    y6 /= m;
                    y7 /= m;
                    y8 /= m;

                    for (int i = 0; i < n; i++) {
                        b0 += array_mid_y[i];
                        b1 += array_mid_y[i] * array_xn[i][0];
                        b2 += array_mid_y[i] * array_xn[i][1];
                        b3 += array_mid_y[i] * array_xn[i][2];
                        b12 += array_mid_y[i] * array_xn[i][0] * array_xn[i][1];
                        b23 += array_mid_y[i] * array_xn[i][1] * array_xn[i][2];
                        b13 += array_mid_y[i] * array_xn[i][0] * array_xn[i][2];
                        b123 += array_mid_y[i] * array_xn[i][0] * array_xn[i][1] * array_xn[i][2];
                    }
                    b0 /= n;
                    b1 /= n;
                    b2 /= n;
                    b3 /= n;
                    b12 /= n;
                    b23 /= n;
                    b13 /= n;
                    b123 /= n;

                    disp1 = 0; disp2 = 0; disp3 = 0; disp4 = 0; disp5 = 0; disp6 = 0; disp7 = 0; disp8 = 0;
                    for (int i = 0; i < ex_array[0].length; i++) {
                        disp1 += Math.pow((ex_array[0][i] - y1), 2);
                        disp2 += Math.pow((ex_array[1][i] - y2), 2);
                        disp3 += Math.pow((ex_array[2][i] - y3), 2);
                        disp4 += Math.pow((ex_array[3][i] - y4), 2);
                        disp5 += Math.pow((ex_array[3][i] - y5), 2);
                        disp6 += Math.pow((ex_array[3][i] - y6), 2);
                        disp7 += Math.pow((ex_array[3][i] - y7), 2);
                        disp8 += Math.pow((ex_array[3][i] - y8), 2);
                    }

                    disp1 /= m;
                    disp2 /= m;
                    disp3 /= m;
                    disp4 /= m;
                    disp5 /= m;
                    disp6 /= m;
                    disp7 /= m;
                    disp8 /= m;

                    exp_kohren += (Math.max((Math.max((Math.max(disp1, disp2)), (Math.max(disp3, disp4)))),
                            (Math.max((Math.max(disp5, disp6)), (Math.max(disp7, disp8)))))) /
                            (disp1 + disp2 + disp3 + disp4 + disp5 + disp6 + disp7 + disp8);

                    m += 1;
                } while (exp_kohren > (mini_kohren[n - 2][(m - 2) - 1]) / 10000);
                m -= 1;

                System.out.println("Дисперсія однорідна при " + m + " дослідах");

                beta0 = 0; beta1 = 0; beta2 = 0; beta3 = 0; beta12 = 0; beta13 = 0; beta23 = 0; beta123 = 0;
                for (int i = 0; i < n; i++) {
                    beta0 += array_mid_y[i] * 1;
                    beta1 += array_mid_y[i] * array_xn[i][0];
                    beta2 += array_mid_y[i] * array_xn[i][1];
                    beta3 += array_mid_y[i] * array_xn[i][2];
                    beta12 += array_mid_y[i] * array_xn[i][3];
                    beta23 += array_mid_y[i] * array_xn[i][4];
                    beta13 += array_mid_y[i] * array_xn[i][5];
                    beta123 += array_mid_y[i] * array_xn[i][6];
                }
                beta0 /= n;
                beta1 /= n;
                beta2 /= n;
                beta3 /= n;
                beta12 /= n;
                beta23 /= n;
                beta23 /= n;
                beta123 /= n;

                s = Math.sqrt((disp1 + disp2 + disp3 + disp4 + disp5 + disp6 + disp7 + disp8) / (n * sum_n * m));

                t0 = beta0 / s;
                t1 = beta1 / s;
                t2 = beta2 / s;
                t3 = beta3 / s;
                t12 = beta12 / s;
                t23 = beta23 / s;
                t13 = beta13 / s;
                t123 = beta123 / s;

                t_tabl = mini_student[(m - 1) * n - 1];
                d = 0; // кількість значущих коефіцієнтів при рівні значимості q = 0.05
                if (t0 < t_tabl) {
                    System.out.println("b0 - незначний коефіцієнт => вилучається з рівняння");
                    b0 = 0;
                } else {
                    d += 1;
                }
                if (t1 < t_tabl) {
                    System.out.println("b1 - незначний коефіцієнт => вилучається з рівняння");
                    b1 = 0;
                } else {
                    d += 1;
                }
                if (t2 < t_tabl) {
                    System.out.println("b2 - незначний коефіцієнт => вилучається з рівняння");
                    b2 = 0;
                } else {
                    d += 1;
                }
                if (t3 < t_tabl) {
                    System.out.println("b3 - незначний коефіцієнт => вилучається з рівняння");
                    b3 = 0;
                } else {
                    d += 1;
                }
                if (t12 < t_tabl) {
                    System.out.println("b12 - незначний коефіцієнт => вилучається з рівняння");
                    b12 = 0;
                } else {
                    d += 1;
                }
                if (t23 < t_tabl) {
                    System.out.println("b23 - незначний коефіцієнт => вилучається з рівняння");
                    b23 = 0;
                } else {
                    d += 1;
                }
                if (t13 < t_tabl) {
                    System.out.println("b13 - незначний коефіцієнт => вилучається з рівняння");
                    b13 = 0;
                } else {
                    d += 1;
                }
                if (t123 < t_tabl) {
                    System.out.println("b123 - незначний коефіцієнт => вилучається з рівняння");
                    b123 = 0;
                } else {
                    d += 1;
                }

                some_array_mid_y = new double[n];
                for (int i = 0; i < some_array_mid_y.length; i++) {
                    some_array_mid_y[i] = b0 + b1 * array_x[i][0] + b2 * array_x[i][1] + b3 * array_x[i][2]
                            + b12 * array_x[i][0] * array_x[i][1] + b23 * array_x[i][1] * array_x[i][2] + b13 * array_x[i][0] * array_x[i][2]
                            + b123 * array_x[i][0] * array_x[i][1] * array_x[i][2];
                }

                s_ad = 0;
                for (int i = 0; i < n; i++) {
                    s_ad += Math.pow((some_array_mid_y[i] - array_mid_y[i]), 2);
                }
                s_ad *= m;
                s_ad /= n - d;
                fp = (s_ad * n) / (disp1 + disp2 + disp3 + disp4 + disp5 + disp6 + disp7 + disp8);
                String text = "y = ";
                if (b0 != 0) {
                    text += b0;
                }
                if (b1 != 0) {
                    text += b1 + "x1 + ";
                }
                if (b2 != 0) {
                    text += b2 + "x2 + ";
                }
                if (b3 != 0) {
                    text += b3 + "x3 + ";
                }
                if (b12 != 0) {
                    text += b12 + "x1*x2 + ";
                }
                if (b23 != 0) {
                    text += b23 + "x2*x3 + ";
                }
                if (b13 != 0) {
                    text += b13 + "x1*x3 + ";
                }
                if (b123 != 0) {
                    text += b123 + "x1*x2*x3";
                }
                if (fp < mini_fisher[(m - 1) * n - 1][n - d - 1]) {
                    System.out.println(text);
                    System.out.println("Рівняння регресії адекватно оригіналу при рівні значимості " + q);
                } else {
                    System.out.println(text);
                    System.out.println("Рівняння регресії неадекватно оригіналу при рівні значимості " + q);
                    n = 15;
                    double[][] square_array_y = new double[15][m];
                    double suma = 0;

                    for (int i = 0; i < array_y.length; i++) {
                        for (int j = 0; j < array_y[i].length; j++) {
                            square_array_y[i][j] = array_y[i][j];
                        }
                    }


                    for (int i = 3; i < array_xn_9_15.length; i++) {
                        for (int j = 0; j < array_xn_9_15[i].length; j++) {
                            if (j < 7) {
                                array_xn_9_15[i][j] = 0;
                            } else {
                                array_xn_9_15[i][j] = Math.pow(array_xn_9_15[i][j - 7], 2);
                            }
                        }
                    }
                    for (int i = 0; i < array_x_9_15.length; i++) {
                        for (int j = 0; j < array_x_9_15[i].length; j++) {
                            if (j < 3) {
                                array_x_9_15[i][j] = array_xn_9_15[i][j] * dx[j] + x0[j];
                            }
                            else if ((j >= 3) && (j < 7)) {
                                array_x_9_15[i][3] = array_x_9_15[i][0] * array_x_9_15[i][1];
                                array_x_9_15[i][4] = array_x_9_15[i][0] * array_x_9_15[i][2];
                                array_x_9_15[i][5] = array_x_9_15[i][1] * array_x_9_15[i][2];
                                array_x_9_15[i][6] = array_x_9_15[i][0] * array_x_9_15[i][1] * array_x_9_15[i][2];
                            } else {
                                array_x_9_15[i][j] = Math.pow(array_x_9_15[i][j - 7], 2);
                            }
                        }
                    }

                    for (int i = 8; i < square_array_y.length; i++) {
                        for (int j = 0; j < square_array_y[i].length; j++) {
                            square_array_y[i][m - 1] = 8.7 + 6.8*array_x_9_15[i - 8][0] + 3.8*array_x_9_15[i - 8][1] + 5.0*array_x_9_15[i - 8][2] +
                                    7.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][0] + 0.6*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][1] + 3.2*array_x_9_15[i - 8][2]*array_x_9_15[i - 8][2] +
                                    5.8*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1] + 0.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][2] + 1.5*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] +
                                    1.4*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] + (int)(Math.random()*10) - 5;
                        }
                    }

                    double[][] cokp_array_x = new double[array_x.length][10];
                    double[][] array_a = new double[10][10];  //матриця з системи рівнянь для знаходження коефіцієнтів р-ння регресії
                    double[] array_m = new double[10];
                    double[][] det = new double[11][11];
                    double[] change_det = new double[11];
                    for (int i = 0; i < cokp_array_x.length; i++) {      //заповнюємо матрицю факторів з урахуванням ефекту взаємодії та квадратичних членів
                        for (int j = 0; j < cokp_array_x[i].length; j++) {
                            if (j < array_x[i].length) {
                                cokp_array_x[i][j] = array_x[i][j];
                            }
                            if (j >= 7) {
                                cokp_array_x[i][j] = array_x[i][j - 7] * array_x[i][j - 7];
                            }
                            if (j == 3) {
                                cokp_array_x[i][j] = array_x[i][0] * array_x[i][1];
                            }
                            if (j == 4) {
                                cokp_array_x[i][j] = array_x[i][0] * array_x[i][2];
                            }
                            if (j == 5) {
                                cokp_array_x[i][j] = array_x[i][1] * array_x[i][2];
                            }
                            if (j == 6) {
                                cokp_array_x[i][j] = array_x[i][0] * array_x[i][1] * array_x[i][2];
                            }
                        }
                    }

                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            array_a[i][j] = 0;
                        }
                        array_m[i] = 0;
                    }
                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            for (int k = 0; k < cokp_array_x.length; k++) {
                                array_a[i][j] += cokp_array_x[k][j] * cokp_array_x[k][i];
                            }
                        }
                    }
                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            array_a[i][j] /= n;
                        }
                    }

                    for (int i = 0; i < array_m.length; i++) {
                        for (int j = 0; j < cokp_array_x.length; j++) {
                            array_m[i] += cokp_array_x[j][i];
                        }
                        array_m[i] /= n;
                    }

                    det[0][0] = 1;
                    for (int i = 1; i < det.length; i++) {
                        for (int j = 1; j < det[i].length; j++) {
                            det[i][j] = array_a[i - 1][j - 1];
                        }
                    }
                    for (int k = 1; k < det.length; k++) {
                        det[0][k] = array_m[k - 1];
                        det[k][0] = array_m[k - 1];
                    }
                    for (int i = 1; i < change_det.length; i++) {
                        change_det[i] = 0;
                        for (int k = 0; k < cokp_array_x.length; k++) {
                            change_det[i] += cokp_array_x[k][i - 1] * array_mid_y[k];
                        }
                        change_det[i] /= n;
                    }

                    change_det[0] = 0;
                    for (int k = 0; k < array_mid_y.length; k++) {
                        change_det[0] += array_mid_y[k];
                    }
                    change_det[0] /= n;

                    double[] array_b = new double[11];   //масив коефіцієгтів р-ння регресії
                    double[][] help_array = new double[det.length][det.length];
                    for (int i = 0; i < help_array.length; i++) {
                        for (int j = 0; j < help_array[i].length; j++) {
                            help_array[i][j] = det[i][j];
                        }
                    }

                    for (int k = 0; k < array_b.length; k++) {
                        for (int t = 0; t < help_array.length; t++) {
                            help_array[t][k] = change_det[t];
                        }
                        array_b[k] = deter(help_array) / deter(det);
                    }
                    do {
                        exp_kohren = 0;
                        double[][] ex_array = new double[square_array_y.length][m];
                        for (int i = 0; i < square_array_y.length; i++) {
                            for (int j = 0; j < square_array_y[i].length; j++) {
                                ex_array[i][j] = square_array_y[i][j];
                            }
                        }
                        if (m > 2) {
                            for (int i = 0; i < ex_array.length; i++) {
                                if(i < 8){
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                            7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                            5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                            1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                                }
                                else{
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x_9_15[i - 8][0] + 3.8*array_x_9_15[i - 8][1] + 5.0*array_x_9_15[i - 8][2] +
                                            7.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][0] + 0.6*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][1] + 3.2*array_x_9_15[i - 8][2]*array_x_9_15[i - 8][2] +
                                            5.8*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1] + 0.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][2] + 1.5*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] +
                                            1.4*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] + (int)(Math.random()*10) - 5;
                                }

                            }
                        }
                        if (m > 3) {
                            for (int i = 0; i < ex_array.length; i++) {
                                if(i < 8){
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                            7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                            5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                            1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                                }
                                else{
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x_9_15[i - 8][0] + 3.8*array_x_9_15[i - 8][1] + 5.0*array_x_9_15[i - 8][2] +
                                            7.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][0] + 0.6*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][1] + 3.2*array_x_9_15[i - 8][2]*array_x_9_15[i - 8][2] +
                                            5.8*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1] + 0.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][2] + 1.5*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] +
                                            1.4*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] + (int)(Math.random()*10) - 5;
                                }
                            }
                        }
                        if (m > 4) {
                            for (int i = 0; i < ex_array.length; i++) {
                                if(i < 8){
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x[i][0] + 3.8*array_x[i][1] + 5.0*array_x[i][2] +
                                            7.9*array_x[i][0]*array_x[i][0] + 0.6*array_x[i][1]*array_x[i][1] + 3.2*array_x[i][2]*array_x[i][2] +
                                            5.8*array_x[i][0]*array_x[i][1] + 0.9*array_x[i][0]*array_x[i][2] + 1.5*array_x[i][1]*array_x[i][2] +
                                            1.4*array_x[i][0]*array_x[i][1]*array_x[i][2] + (int)(Math.random()*10) - 5;
                                }
                                else{
                                    ex_array[i][m - 1] = 8.7 + 6.8*array_x_9_15[i - 8][0] + 3.8*array_x_9_15[i - 8][1] + 5.0*array_x_9_15[i - 8][2] +
                                            7.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][0] + 0.6*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][1] + 3.2*array_x_9_15[i - 8][2]*array_x_9_15[i - 8][2] +
                                            5.8*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1] + 0.9*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][2] + 1.5*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] +
                                            1.4*array_x_9_15[i - 8][0]*array_x_9_15[i - 8][1]*array_x_9_15[i - 8][2] + (int)(Math.random()*10) - 5;
                                }
                            }
                        }
                        y1 = 0; y2 = 0; y3 = 0; y4 = 0; y5 = 0; y6 = 0; y7= 0; y8 = 0; y9= 0; y10= 0; y11= 0; y12 = 0; y13 = 0; y14 = 0; y15 = 0;
                        for (int i = 0; i < array_y[0].length; i++) {
                            y1 += ex_array[0][i];
                            y2 += ex_array[1][i];
                            y3 += ex_array[2][i];
                            y4 += ex_array[3][i];
                            y5 += ex_array[4][i];
                            y6 += ex_array[5][i];
                            y7 += ex_array[6][i];
                            y9 += ex_array[7][i];
                            y10 += ex_array[7][i];
                            y11 += ex_array[7][i];
                            y12 += ex_array[7][i];
                            y13 += ex_array[7][i];
                            y14 += ex_array[7][i];
                            y15 += ex_array[7][i];
                        }
                        y1 /= m;
                        y2 /= m;
                        y3 /= m;
                        y4 /= m;
                        y5 /= m;
                        y6 /= m;
                        y7 /= m;
                        y8 /= m;
                        y9 /= m;
                        y10 /= m;
                        y11 /= m;
                        y12 /= m;
                        y13 /= m;
                        y14 /= m;
                        y15 /= m;

                        double[] disp = new double[15];

                        array_mid_y = new double[]{y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12, y13, y14, y15};

                        for (int i = 0; i < ex_array[0].length; i++) {
                            for (int k = 0; k < ex_array.length; k++) {
                                disp[k] += Math.pow((ex_array[k][i] - array_mid_y[k]), 2);
                            }
                        }

                        for (int j = 0; j < disp.length; j++) {
                            disp[j] /= m;
                        }

                        Sheiker(disp, disp.length);

                        exp_kohren += disp[disp.length - 1];
                        for (int i = 0; i < disp.length; i++) {
                            suma += disp[i];
                        }
                        exp_kohren /= suma;

                        m += 1;

                    } while (exp_kohren > (mini_kohren[n - 2][(m - 2) - 1]) / 10000);
                    m -= 1;
                    System.out.println("Дисперсія однорідна при " + m + " дослідах");


                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            array_a[i][j] = 0;
                        }
                        array_m[i] = 0;
                    }
                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            for (int k = 0; k < cokp_array_x.length; k++) {
                                array_a[i][j] += cokp_array_x[k][j] * cokp_array_x[k][i];
                            }
                        }
                    }
                    for (int i = 0; i < array_a.length; i++) {
                        for (int j = 0; j < array_a[i].length; j++) {
                            array_a[i][j] /= n;
                        }
                    }

                    for (int i = 0; i < array_m.length; i++) {
                        for (int j = 0; j < cokp_array_x.length; j++) {
                            array_m[i] += cokp_array_x[j][i];
                        }
                        array_m[i] /= n;
                    }
                    det[0][0] = 1;
                    for (int i = 1; i < det.length; i++) {
                        for (int j = 1; j < det[i].length; j++) {
                            det[i][j] = array_a[i - 1][j - 1];
                        }
                    }
                    for (int k = 1; k < det.length; k++) {
                        det[0][k] = array_m[k - 1];
                        det[k][0] = array_m[k - 1];
                    }
                    for (int i = 1; i < change_det.length; i++) {
                        change_det[i] = 0;
                        for (int k = 0; k < cokp_array_x.length; k++) {
                            change_det[i] += cokp_array_x[k][i - 1] * array_mid_y[k];
                        }
                        change_det[i] /= n;
                    }

                    change_det[0] = 0;
                    for (int k = 0; k < array_mid_y.length; k++) {
                        change_det[0] += array_mid_y[k];
                    }
                    change_det[0] /= n;

                    for (int i = 0; i < help_array.length; i++) {
                        for (int j = 0; j < help_array[i].length; j++) {
                            help_array[i][j] = det[i][j];
                        }
                    }

                    for (int k = 0; k < array_b.length; k++) {
                        for (int t = 0; t < help_array.length; t++) {
                            help_array[t][k] = change_det[t];
                        }
                        array_b[k] = deter(help_array) / deter(det);
                    }


                    double beta11 = 0, beta22 = 0, beta33 = 0;
                    beta0 = 0; beta1 = 0; beta2 = 0; beta3 = 0; beta12 = 0; beta13 = 0; beta23 = 0; beta123 = 0;
                    for (int i = 0; i < n; i++) {
                        beta0 += array_mid_y[i];
                        if (i < 8) {
                            beta1 += array_mid_y[i] * array_xn[i][0];
                            beta2 += array_mid_y[i] * array_xn[i][1];
                            beta3 += array_mid_y[i] * array_xn[i][2];
                            beta12 += array_mid_y[i] * array_xn[i][3];
                            beta23 += array_mid_y[i] * array_xn[i][4];
                            beta13 += array_mid_y[i] * array_xn[i][5];
                            beta123 += array_mid_y[i] * array_xn[i][6];
                            beta11 += array_mid_y[i] * Math.pow(array_xn[i][0], 2);
                            beta22 += array_mid_y[i] * Math.pow(array_xn[i][1], 2);
                            beta33 += array_mid_y[i] * Math.pow(array_xn[i][2], 2);
                        } else {
                            beta1 += array_mid_y[i] * array_xn_9_15[i - 8][0];
                            beta2 += array_mid_y[i] * array_xn_9_15[i - 8][1];
                            beta3 += array_mid_y[i] * array_xn_9_15[i - 8][2];
                            beta12 += array_mid_y[i] * array_xn_9_15[i - 8][3];
                            beta23 += array_mid_y[i] * array_xn_9_15[i - 8][4];
                            beta13 += array_mid_y[i] * array_xn_9_15[i - 8][5];
                            beta123 += array_mid_y[i] * array_xn_9_15[i - 8][6];
                            beta11 += array_mid_y[i] * Math.pow(array_xn_9_15[i - 8][0], 2);
                            beta22 += array_mid_y[i] * Math.pow(array_xn_9_15[i - 8][1], 2);
                            beta33 += array_mid_y[i] * Math.pow(array_xn_9_15[i - 8][2], 2);
                        }

                    }
                    beta0 /= n;
                    beta1 /= n;
                    beta2 /= n;
                    beta3 /= n;
                    beta12 /= n;
                    beta23 /= n;
                    beta23 /= n;
                    beta123 /= n;
                    beta11 /= n;
                    beta22 /= n;
                    beta33 /= n;

                    for (int i = 1; i <= n; i++) {
                        sum_n += i;
                    }

                    s = Math.sqrt(suma / (n * sum_n * m));

                    double t11, t22, t33;

                    t0 = beta0 / s;
                    t1 = beta1 / s;
                    t2 = beta2 / s;
                    t3 = beta3 / s;
                    t12 = beta12 / s;
                    t23 = beta23 / s;
                    t13 = beta13 / s;
                    t123 = beta123 / s;
                    t11 = beta11 / s;
                    t22 = beta22 / s;
                    t33 = beta33 / s;

                    t_tabl = mini_student[(m - 1) * n - 1];
                    d = 0; // кількість значущих коефіцієнтів при рівні значимості q = 0.05

                    if (t0 < t_tabl) {
                        System.out.println("b0 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[0] = 0;
                    } else {
                        d += 1;
                    }
                    if (t1 < t_tabl) {
                        System.out.println("b1 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[1] = 0;
                    } else {
                        d += 1;
                    }
                    if (t2 < t_tabl) {
                        System.out.println("b2 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[2] = 0;
                    } else {
                        d += 1;
                    }
                    if (t3 < t_tabl) {
                        System.out.println("b3 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[3] = 0;
                    } else {
                        d += 1;
                    }
                    if (t12 < t_tabl) {
                        System.out.println("b12 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[4] = 0;
                    } else {
                        d += 1;
                    }
                    if (t23 < t_tabl) {
                        System.out.println("b23 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[5] = 0;
                    } else {
                        d += 1;
                    }
                    if (t13 < t_tabl) {
                        System.out.println("b13 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[6] = 0;
                    } else {
                        d += 1;
                    }
                    if (t123 < t_tabl) {
                        System.out.println("b123 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[7] = 0;
                    } else {
                        d += 1;
                    }
                    if (t11 < t_tabl) {
                        System.out.println("b11 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[8] = 0;
                    } else {
                        d += 1;
                    }
                    if (t22 < t_tabl) {
                        System.out.println("b22 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[9] = 0;
                    } else {
                        d += 1;
                    }
                    if (t33 < t_tabl) {
                        System.out.println("b33 - незначний коефіцієнт => вилучається з рівняння");
                        array_b[10] = 0;
                    } else {
                        d += 1;
                    }

                    some_array_mid_y = new double[n];
                    for (int i = 0; i < some_array_mid_y.length; i++) {
                        if (i < 8) {
                            some_array_mid_y[i] = array_b[0] + array_b[1] * array_x[i][0] + array_b[2] * array_x[i][1] + array_b[3] * array_x[i][2]
                                    + array_b[4] * array_x[i][0] * array_x[i][1] + array_b[5] * array_x[i][1] * array_x[i][2] + array_b[6] * array_x[i][0] * array_x[i][2]
                                    + array_b[7] * array_x[i][0] * array_x[i][1] * array_x[i][2] + array_b[8] * array_x[i][0] * array_x[i][0]
                                    + array_b[9] * array_x[i][1] * array_x[i][1] + array_b[10] * array_x[i][2] * array_x[i][2];
                        } else {
                            some_array_mid_y[i] = array_b[0] + array_b[1] * array_x_9_15[i - 8][0] + array_b[2] * array_x_9_15[i - 8][1] + array_b[3] * array_x_9_15[i - 8][2]
                                    + array_b[4] * array_x_9_15[i - 8][0] * array_x_9_15[i - 8][1] + array_b[5] * array_x_9_15[i - 8][1] * array_x_9_15[i - 8][2]
                                    + array_b[6] * array_x_9_15[i - 8][0] * array_x_9_15[i - 8][2]
                                    + array_b[7] * array_x_9_15[i - 8][0] * array_x_9_15[i - 8][1] * array_x_9_15[i - 8][2] + array_b[8] * array_x_9_15[i - 8][0] * array_x_9_15[i - 8][0]
                                    + array_b[9] * array_x_9_15[i - 8][1] * array_x_9_15[i - 8][1] + array_b[10] * array_x_9_15[i - 8][2] * array_x_9_15[i - 8][2];
                        }
                    }

                    s_ad = 0;
                    for (int i = 0; i < n; i++) {
                        s_ad += Math.pow((some_array_mid_y[i] - array_mid_y[i]), 2);
                    }
                    s_ad *= m;
                    s_ad /= n - d;
                    fp = (s_ad * n) / (suma);
                    System.out.println(fp);

                    int f1 = (m - 1) * n - 1;
                    int f2 = n - d - 1;
                    if (f1 > 21) {
                        f1 = 21;
                    }
                    if (f2 > 6) {
                        f2 = 6;
                    }
                    String text1 = "y = ";
                    if (array_b[0] != 0) {
                        text1 += array_b[0];
                    }
                    if (array_b[1] != 0) {
                        text1 += array_b[1] + "x1 + ";
                    }
                    if (array_b[2] != 0) {
                        text1 += array_b[2] + "x2 + ";
                    }
                    if (array_b[3] != 0) {
                        text1 += array_b[3] + "x3 + ";
                    }
                    if (array_b[4] != 0) {
                        text1 += array_b[4] + "x1*x2 + ";
                    }
                    if (array_b[5] != 0) {
                        text1 += array_b[5] + "x2*x3 + ";
                    }
                    if (array_b[6] != 0) {
                        text1 += array_b[6] + "x1*x3 + ";
                    }
                    if (array_b[7] != 0) {
                        text1 += array_b[7] + "x1*x2*x3 + ";
                    }
                    if (array_b[8] != 0) {
                        text1 += array_b[8] + "x1*x1 + ";
                    }
                    if (array_b[9] != 0) {
                        text1 += array_b[9] + "x2*x2 + ";
                    }
                    if (array_b[10] != 0) {
                        text1 += array_b[10] + "x3*x3";
                    }
                    if (fp < mini_fisher[f1][f2]) {
                        System.out.println(text1);
                        System.out.println("Рівняння регресії адекватно оригіналу при рівні значимості " + q);
                    }
                    else{
                        System.out.println(text1);
                        System.out.println("Рівняння регресії неадекватно оригіналу при рівні значимості " + q);
                    }
                }
            }
    }

    public static double Kramer(double[][] a1/*, double[][] a2*/){ //метод для розрахунку визначників 3*3
        /*double result;
        double delta;*/
        double resh;
        resh = a1[0][0]*a1[1][1]*a1[2][2] + a1[0][1]*a1[1][2]*a1[2][0] + a1[1][0]*a1[0][2]*a1[2][1] -
                a1[0][2]*a1[1][1]*a1[2][0] - a1[0][0]*a1[1][2]*a1[2][1] - a1[0][1]*a1[1][0]*a1[2][2];
        /*delta = a2[0][0]*a2[1][1]*a2[2][2] + a2[0][1]*a2[1][2]*a2[2][0] + a2[1][0]*a2[0][2]*a2[2][1] -
                a2[0][2]*a2[1][1]*a2[2][0] - a2[0][0]*a2[1][2]*a2[2][1] - a2[0][1]*a2[1][0]*a2[2][2];*/
        /*result = resh/delta;*/
        return resh;
    }

    public static double Delta(double[][] array){  //метод для розрахунку визначників 4*4
        int len = array.length;
        double resh_help = 0;

        for(int i = 0; i < len; i++){
            double[][] array_delta = new double[array.length - 1][array[0].length - 1];
            for(int j = 0; j < len; j++){
                for(int k = 1; k < len; k++){
                    if(j == i){
                        break;
                    }
                    else if(j < i){
                        array_delta[j][k-1] = array[j][k];
                    }
                    else{
                        array_delta[j-1][k-1] = array[j][k];
                    }
                }
            }
            if((double)i%2 == 0.0){
                resh_help += Kramer(array_delta) * array[i][0];
            }
            else{
                resh_help -= Kramer(array_delta) * array[i][0];
            }
        }
        return resh_help;
    }

    public static double deter(double[][] mat) {
        if (mat.length == 1)
            return mat[0][0];
        if (mat.length == 2)
            return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
        int sum = 0, sign = 1;
        int newN = mat.length - 1;
        double[][] temp = new double[newN][newN];
        for (int t = 0; t < newN; t++) {
            int q = 0;
            for (int i = 0; i < newN; i++) {
                for (int j = 0; j < newN; j++) {
                    temp[i][j] = mat[1 + i][q + j];
                }
                if (q == i)
                    q = 1;
            }
            sum += sign * mat[0][t] * deter(temp);
            sign *= -1;
        }
        return sum;
    }
    public static double[] Sheiker(double[] a, int n){
        int left = 1;
        int right = n-1;
        int j, k = n-1;
        double t = n - 1;
        do{
            for (j = right; j >= left; j--){
                if(a[j-1] > a[j]){
                    t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                    k = j;
                }
            }
            left = k+1;
            for (j = left; j <= right; j++){
                if(a[j-1] > a[j]){
                    t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                    k = j;
                }
            }
            right = k-1;
        } while (left <= right);
        return a;
    }
}
