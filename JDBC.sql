CREATE TABLE companies
(
  company_id SMALLINT,
  company VARCHAR(20),
  number_of_employees SMALLINT
);
INSERT INTO companies VALUES(100, 'IBM', 12000);
INSERT INTO companies VALUES(101, 'GOOGLE', 18000);
INSERT INTO companies VALUES(102, 'MICROSOFT', 10000);
INSERT INTO companies VALUES(103, 'APPLE', 21000);
SELECT * FROM companies;

--1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company
 --       // ve number_of_employees değerlerini çağırın.
 
 --1. yol offset ve fetch next kullanarak
 select company,number_of_employees
 from companies
 order by number_of_employees desc
 offset 1 row
 fetch next 1 row only;--18000 google
 
  select company,number_of_employees
 from companies
 where number_of_employees=(select max(number_of_employees)
                            from companies
							 where number_of_employees<(select max(number_of_employees)
							 from companies))
 
 
 --1. Örnek: number_of_employees değeri ortalama çalışan sayısından
-- az olan number_of_employees değerlerini 16000 olarak UPDATE edin.
update companies
set number_of_employees=16000
where number_of_employees<(select avg(number_of_employees)
from companies);

--1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin
 
 update companies
 set number_of_employees=9999
 where company='IBM'
 
 
 
 
 