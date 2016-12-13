package springapp.db;

import java.util.List;

import springapp.domain.BusSchedule;

public interface BusScheduleDao 
{
    public List<BusSchedule> getBusList();

    public void saveBus(BusSchedule bus);
}
