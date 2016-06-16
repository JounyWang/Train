package cn.train.dao;

import java.util.List;

import cn.train.entity.Train;
import cn.train.util.Page;

public interface TrainDAO {
	public void add(Train train) throws Exception;

	public void del(Train train) throws Exception;

	public void delAll(String[] arr) throws Exception;

	public Train find(Train train) throws Exception;

	public List<Train> getAlltrain(Page page, String trainNumber)
			throws Exception;

	public int getCount();

	public void update(Train train) throws Exception;
}
