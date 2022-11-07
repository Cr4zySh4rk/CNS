BEGIN{
}
{
If ($6=="cwnd_")
printf("%f\t%f\t\n",$1,$7);
}
END{
}
