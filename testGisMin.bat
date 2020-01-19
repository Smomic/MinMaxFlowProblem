call echo "MIN P 0.2 TN 10" >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.2 -w 50 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.2 -w 100 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.2 -w 200 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.2 -w 300 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.2 -w 400 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.2 -w 500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.2 -w 600 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.2 -w 700 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.2 -w 800 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.2 -w 900 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.2 -w 1000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.2 -w 1500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.2 -w 2000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.2 -w 2500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.2 -w 3000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.2 -w 4000 -min -tn 10" >> testGisMIN.txt

call echo "MIN P 0.2 TN 10 scc " >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.2 -w 50 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.2 -w 100 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.2 -w 200 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.2 -w 300 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.2 -w 400 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.2 -w 500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.2 -w 600 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.2 -w 700 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.2 -w 800 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.2 -w 900 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.2 -w 1000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.2 -w 1500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.2 -w 2000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.2 -w 2500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.2 -w 3000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.2 -w 4000 -min -scc -tn 10" >> testGisMIN.txt

call echo "MIN P 0.5 TN 10" >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.5 -w 50 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.5 -w 100 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.5 -w 200 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.5 -w 300 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.5 -w 400 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.5 -w 500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.5 -w 600 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.5 -w 700 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.5 -w 800 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.5 -w 900 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.5 -w 1000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.5 -w 1500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.5 -w 2000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.5 -w 2500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.5 -w 3000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.5 -w 4000 -min -tn 10" >> testGisMIN.txt

call echo "MIN P 0.5 TN 10 SCC" >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.5 -w 50 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.5 -w 100 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.5 -w 200 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.5 -w 300 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.5 -w 400 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.5 -w 500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.5 -w 600 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.5 -w 700 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.5 -w 800 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.5 -w 900 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.5 -w 1000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.5 -w 1500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.5 -w 2000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.5 -w 2500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.5 -w 3000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.5 -w 4000 -min -scc -tn 10" >> testGisMIN.txt

call echo "MIN P 0.8 TN 10" >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.8 -w 50 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.8 -w 100 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.8 -w 200 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.8 -w 300 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.8 -w 400 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.8 -w 500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.8 -w 600 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.8 -w 700 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.8 -w 800 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.8 -w 900 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.8 -w 1000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.8 -w 1500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.8 -w 2000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.8 -w 2500 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.8 -w 3000 -min -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.8 -w 4000 -min -tn 10" >> testGisMIN.txt

call echo "MIN P 0.8 TN 10 SCC" >> testGisMIN.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.8 -w 50 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.8 -w 100 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.8 -w 200 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.8 -w 300 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.8 -w 400 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.8 -w 500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.8 -w 600 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.8 -w 700 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.8 -w 800 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.8 -w 900 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.8 -w 1000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.8 -w 1500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.8 -w 2000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.8 -w 2500 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.8 -w 3000 -min -scc -tn 10" >> testGisMIN.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.8 -w 4000 -min -scc -tn 10" >> testGisMIN.txt

