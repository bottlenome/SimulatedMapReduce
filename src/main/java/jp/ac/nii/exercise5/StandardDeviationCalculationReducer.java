package jp.ac.nii.exercise5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

import com.google.common.collect.Maps;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.Reducer;

/**
 * TODO: このファイルは未完成です！
 */
public class StandardDeviationCalculationReducer extends Reducer<String, Integer, String, Double> {
	private Map<String, Double> subject2Average = Maps.newHashMap();

	@Override
	protected void setup(Context context) {
		// 注意：以下は分散キャッシュ（DistributedCache）から平均値の計算結果の読み込みを行なっているが、本家Hadoopとは処理が大きく異なります！
		try {
			FileInputStream intput = new FileInputStream("exercise5_average.tsv");
			Scanner scanner = new Scanner(intput, "UTF-8");
			while (scanner.hasNextLine()) {
				// TODO: subject2Averageに科目名と平均値のキーバリューを保存しよう
				String[] keyValue = scanner.nextLine().split("\t");
				// 平均値データの設定
				subject2Average.put(keyValue[0], Double.valueOf(keyValue[1]));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void reduce(String key, Iterable<Integer> values, Context context) {
		// TODO: 分散を計算しよう
		// ヒント: subject2Average フィールドを使おう！
		double sum = 0;
		double average = subject2Average.get(key);
		int count = 0;
		for (Integer value : values) {
			sum += Math.pow((value - average), 2);
			count += 1;
		}
		context.write(key, Math.sqrt(sum/count));
	}
}
