package cn.train.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.train.entity.Train;
import cn.train.util.Page;

@Repository("trainDAO")
@SuppressWarnings("all")
public class TrainDAOImpl implements TrainDAO {

	@Resource(name = "hibernateTemplate")
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 添加列车信息
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@Override
	public void add(Train train) throws Exception {
		try {
			getHibernateTemplate().save(train);
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	/**
	 * 删除单个列车
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@Override
	public void del(Train train) throws Exception {
		try {
			getHibernateTemplate().delete(
					getHibernateTemplate().get(Train.class,
							train.getTrainNumber()));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * 删除多条列车信息
	 * 
	 * @param request
	 * @param array
	 * @return
	 */
	@Override
	public void delAll(String[] arr) throws Exception {
		for (String id : arr) {
			// Integer trainNumber = Integer.parseInt(id);
			getHibernateTemplate().delete(
					getHibernateTemplate().get(Train.class,
							Integer.parseInt(id)));
		}
	}

	/**
	 * 显示单个列车详细信息
	 * 
	 * @param train
	 * @param request
	 * @return
	 */
	@Override
	public Train find(Train train) throws Exception {
		return getHibernateTemplate().get(Train.class, train.getTrainNumber());

	}

	/**
	 * 修改单个列车信息
	 * 
	 * @param request
	 * @param train
	 * @return
	 */
	@Override
	public void update(Train train) throws Exception {
		getHibernateTemplate().saveOrUpdate(train);

	}

	/**
	 * 显示全部列车信息
	 * 
	 * @param request
	 * @param page
	 * @param trainNumber
	 * @return
	 */
	@Override
	public List<Train> getAlltrain(final Page page, final String trainNumber) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				List<Train> list = null;
				String hql = "";
				Query q = null;
				if (trainNumber == null) {
					hql = "from Train";
					q = s.createQuery(hql);
				} else {
					hql = "from Train where 1=1 ";
					if (!trainNumber.equals("")) {
						hql += " and train_no  like '%" + trainNumber + "%'";
					}
					q = s.createQuery(hql);
				}
				// 设置起点
				q.setFirstResult((page.getCurrentPage() - 1)
						* page.getPageSize());
				// 设置最大显示值
				q.setMaxResults(Integer.parseInt(page.getPageSize().toString()));
				list = q.list();
				return list;
			}
		});
	}

	/**
	 * 获取数据库列车个数
	 */
	@Override
	public int getCount() {
		return hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session s) throws HibernateException,
					SQLException {
				String counthql = "";
				counthql = "select count(train_Number) from Train ";
				Query q = s.createQuery(counthql);
				Integer count = Integer.parseInt(q.uniqueResult().toString());
				return count;
			}

		});
	}

}
