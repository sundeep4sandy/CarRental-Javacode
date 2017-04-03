#query

select Owner_id,Car_type,MODEL,sum(Weekly_rate) from car group by Owner_id;

select Owner_id,Car_type,MODEL,sum(Weekly_rate) from car group by Car_type;

select Owner_id,Car_type,MODEL,sum(Weekly_rate) from car group by Owner_id,Car_type,MODEL;

#code logic


(select car.v_id,car.Cid,daily.Rental_idi,car.Car_type,car.MODEL from daily inner join rentals inner join car where car.V_id=rentals.V_id and rentals.Rental_idi=daily.Rental_idi and '2015-11-21' between D_sdate and D_rdate)

union
(select car.v_id,car.Cid,weekly.Rental_idi,car.Car_type,car.MODEL from weekly inner join rentals inner join car where car.V_id=rentals.V_id and rentals.Rental_idi=weekly.Rental_idi and '2015-11-21' between W_start_dt and W_Rdate);

#code logic 

select ((d.No_days *  c.Daily_rate)- r.Amount_paid) as due
from daily as d, car as c, rentals as r 
where d.Rental_idi='aa101'and  c.V_id = r.V_id and d.Rental_idi = r.Rental_idi ;