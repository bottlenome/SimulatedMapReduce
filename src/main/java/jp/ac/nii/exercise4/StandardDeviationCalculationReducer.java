package jp.ac.nii.exercise4;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.Reducer;

/**
 * TODO: このファイルは未完成です！
 */
public class StandardDeviationCalculationReducer extends Reducer<String, Integer, String, Double> {
	@Override
	protected void reduce(String key, Iterable<Integer> values, Context context) {
		// TODO: 分散を計算しよう
		// ヒント1: context.getConfiguration().get() メソッドを使おう！
		// ヒント2: Excercise4Main.createConfiguration()メソッドをよく読もう！
		double sum = 0;
		double average = Double.parseDouble(context.getConfiguration().get(key));
		int count = 0;
		for (Integer value : values) {
			sum += Math.pow((value - average), 2);
			count += 1;
		}
		context.write(key, Math.sqrt(sum/count));
	}
}
