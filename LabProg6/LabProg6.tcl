set stop 100
set type cdma
set minth 0
set maxth 30
set adaptive 1
set window 30
set web 2
set opt(wrap) 100
set opt(srcTrace) is
set opt(dstTrace) bs2
set bwDL(cdma) 384000
set bwUL(cdma) 64000

set propDL(cdma) .150

set propUL(cdma) .150

set ns [new Simulator]
set tf [open out.tr w]
$ns trace-all $tf
set namf [open out.nam w]
$ns namtrace-all $namf

set nodes(is) [$ns node]
set nodes(ms) [$ns node]
set nodes(bs1) [$ns node]
set nodes(bs2) [$ns node]
set nodes(lp) [$ns node]


proc cell_topo {} {
 global ns nodes
 $ns duplex-link $nodes(lp) $nodes(bs1) 3Mbps 10nodes(ms) DropTail
 $ns duplex-link $nodes(bs1) $nodes(ms) 1 1 RED
 $ns duplex-link $nodes(ms) $nodes(bs2) 1 1 RED  
 $ns duplex-link $nodes(bs2) $nodes(is) 3Mbps 50nodes(ms) DropTail
 puts "CDMA cell Topology"
}
proc set_link_para {t} {
 global ns nodes bwUL bwDL propUL propDL buf
 $ns bandwidth $nodes(bs1) $nodes(ms) $bwDL($t) duplex
 $ns bandwidth $nodes(bs2) $nodes(ms) $bwDL($t) duplex
 $ns delay $nodes(bs1) $nodes(ms) $propDL($t) duplex
 $ns delay $nodes(bs2) $nodes(ms) $propDL($t) duplex
 $ns queue-limit $nodes(bs1) $nodes(ms) 10
 $ns queue-limit $nodes(bs2) $nodes(ms) 10
}

Queue/RED set adaptive_ $adaptive
Queue/RED set thresh_ $minth
Queue/RED set maxthresh_ $maxth
Agent/TCP set window_ $window


switch $type {
 cdma {cell_topo}
}


set_link_para $type

set tcp1 [new Agent/TCP]
$ns attach-agent $nodes(is) $tcp1
set sink1 [new Agent/TCPSink]
$ns attach-agent $nodes(lp) $sink1
$ns connect $tcp1 $sink1
set ftp1 [new Application/FTP]
$ftp1 attach-agent $tcp1
$ns at 0.8 "[set ftp1] start"

proc stop {} {
 global nodes opt nf
 set wrap $opt(wrap)
 set sid [$nodes($opt(srcTrace)) id]
 set did [$nodes($opt(dstTrace)) id]
 set a "out.tr"
 set GETRC "~/ns-allinone-2.35/ns-2.35/bin/getrc"
 set RAW2XG "~/ns-allinone-2.35/ns-2.35/bin/raw2xg"
 exec $GETRC -s $sid -d $did -f 0 out.tr | \
 $RAW2XG -s 0.01 -m $wrap -r > plot.xgr
 exec $GETRC -s $did -d $sid -f 0 out.tr | \
 $RAW2XG -a -s 0.01 -m $wrap >> plot.xgr
 exec xgraph -x time -y packets plot.xgr &
  exec nam LabProg6.nam &
 exit 0
}
$ns at $stop "stop"
$ns run
