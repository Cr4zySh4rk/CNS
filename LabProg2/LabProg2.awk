BEGIN { c=0;
}
{
If ($1=="d")
{
c++
}
}
END{
printf("The number of packets dropped due to congestion is = %d\n",c);
}
