package springapp.db;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import springapp.domain.BusSchedule;
import springapp.domain.Product;

public class HibernateBusScheduleDao implements BusScheduleDao
{

	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) 
    {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.hibernateTemplate.setCheckWriteOperations(false);
	}
	
	@Override
	public List<BusSchedule> getBusList() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(BusSchedule.class);
	}

	@Override
	public void saveBus(BusSchedule bus) {
		hibernateTemplate.saveOrUpdate(bus);

	}

}
