--function olusturma 
--//1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun
create or replace function toplamaf(x numeric,y numeric)
returns numeric
language plpgsql
as
$$
begin
return x+y;
end
$$

select * from toplamaF(15,25) as toplam;