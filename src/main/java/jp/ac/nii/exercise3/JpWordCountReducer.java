package jp.ac.nii.exercise3;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.Reducer;

/**
 * このファイルは完成しています。
 */
public class JpWordCountReducer extends Reducer<String, Integer, String, Integer> {
	@Override
	protected void reduce(String key, Iterable<Integer> values, Context context) {
		int sum = 0;
		for (Integer value : values) {
			sum += value;
		}
		context.write(key, sum);
	}
}
