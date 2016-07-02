package jp.ac.nii.exercise6;

import jp.ac.nii.mapreduceframework.Context;
import jp.ac.nii.mapreduceframework.NullWritable;
import jp.ac.nii.mapreduceframework.Reducer;

/**
 * 以下の式の分子（numerator）を計算するジョブのReducerです。 
 * 関連度 = 商品Xと商品Yのペアの総数 / 商品Xを含むペアの総数
 */
public class SpecPairAggregationReducer extends Reducer<String, Integer, NullWritable, String> {

	private static final NullWritable nullWritable = NullWritable.get();

	@Override
	public void reduce(String key, Iterable<Integer> values, Context context) {
		// TODO: 「商品X,商品Y」という商品ペアの出現頻度を計算しよう
		int sum = 0;
		// TODO: ワードカウントと同じ要領でvaluesの合計を計算して、keyの商品の出現回数を計算しよう
		for (Integer value : values) {
			sum += value;
		}
		// TODO: キーはなしで、「商品X,商品Y,ペアの出現頻度」というバリューを出力しよう
		context.write(nullWritable, key + "," + sum);
	}
}
