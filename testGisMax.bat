call echo "MAX P 0.2 TN 10" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.2 -w 50 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.2 -w 100 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.2 -w 200 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.2 -w 300 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.2 -w 400 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.2 -w 500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.2 -w 600 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.2 -w 700 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.2 -w 800 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.2 -w 900 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.2 -w 1000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.2 -w 1500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.2 -w 2000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.2 -w 2500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.2 -w 3000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.2 -w 4000 -max -tn 10" >> testGisMAX.txt

call echo "MAX P 0.2 TN 10 SCC" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.2 -w 50 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.2 -w 100 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.2 -w 200 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.2 -w 300 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.2 -w 400 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.2 -w 500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.2 -w 600 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.2 -w 700 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.2 -w 800 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.2 -w 900 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.2 -w 1000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.2 -w 1500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.2 -w 2000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.2 -w 2500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.2 -w 3000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.2 -w 4000 -max -scc -tn 10" >> testGisMAX.txt

call echo "MAX P 0.5 TN 10" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.5 -w 50 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.5 -w 100 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.5 -w 200 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.5 -w 300 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.5 -w 400 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.5 -w 500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.5 -w 600 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.5 -w 700 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.5 -w 800 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.5 -w 900 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.5 -w 1000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.5 -w 1500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.5 -w 2000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.5 -w 2500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.5 -w 3000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.5 -w 4000 -max -tn 10" >> testGisMAX.txt

call echo "MAX P 0.5 TN 10 SCC" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.5 -w 50 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.5 -w 100 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.5 -w 200 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.5 -w 300 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.5 -w 400 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.5 -w 500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.5 -w 600 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.5 -w 700 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.5 -w 800 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.5 -w 900 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.5 -w 1000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.5 -w 1500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.5 -w 2000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.5 -w 2500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.5 -w 3000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.5 -w 4000 -max -scc -tn 10" >> testGisMAX.txt

call echo "MAX P 0.8 TN 10" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.8 -w 50 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.8 -w 100 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.8 -w 200 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.8 -w 300 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.8 -w 400 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.8 -w 500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.8 -w 600 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.8 -w 700 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.8 -w 800 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.8 -w 900 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.8 -w 1000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.8 -w 1500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.8 -w 2000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.8 -w 2500 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.8 -w 3000 -max -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.8 -w 4000 -max -tn 10" >> testGisMAX.txt

call echo "MAX P 0.8 TN 10 SCC" >> testGisMAX.txt

call gradle run -q --args="-n 500 -vs 0 -ve 250 -p 0.8 -w 50 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 1000 -vs 0 -ve 500 -p 0.8 -w 100 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 2000 -vs 0 -ve 1000 -p 0.8 -w 200 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 3000 -vs 0 -ve 1500 -p 0.8 -w 300 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 4000 -vs 0 -ve 2000 -p 0.8 -w 400 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 5000 -vs 0 -ve 2500 -p 0.8 -w 500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 6000 -vs 0 -ve 3000 -p 0.8 -w 600 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 7000 -vs 0 -ve 3500 -p 0.8 -w 700 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 8000 -vs 0 -ve 4000 -p 0.8 -w 800 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 9000 -vs 0 -ve 4500 -p 0.8 -w 900 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 10000 -vs 0 -ve 5000 -p 0.8 -w 1000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 15000 -vs 0 -ve 7500 -p 0.8 -w 1500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 20000 -vs 0 -ve 10000 -p 0.8 -w 2000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 25000 -vs 0 -ve 12500 -p 0.8 -w 2500 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 30000 -vs 0 -ve 15000 -p 0.8 -w 3000 -max -scc -tn 10" >> testGisMAX.txt
call gradle run -q --args="-n 40000 -vs 0 -ve 20000 -p 0.8 -w 4000 -max -scc -tn 10" >> testGisMAX.txt
