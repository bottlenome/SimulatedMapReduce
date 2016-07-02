package jp.ac.nii.exercise5;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.Reducer;

/**
 * TODO: このファイルは未完成です！
 */
public class AverageCalculationReducer extends Reducer<String, Integer, String, Double> {
	@Override
	protected void reduce(String key, Iterable<Integer> values, Context context) {
		// TODO: 平均値を計算しよう（Excercise4と同じ）
		double sum = 0;
		int count = 0;
		for (Integer value : values) {
			sum += value;
			count += 1;
		}
		context.write(key, sum/count);
	}
}
