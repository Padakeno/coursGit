<?php

for ($i=1; $i<=6; $i++)
{
	for ($j=1; $j<=3; $j++)
	{
		$ip = "172.20.197." . $i . $j;
		system("ping -c 1 -W  1 $ip > /dev/null", $val);

		switch ($val)
		{
			case 0:
				echo "Adresse $ip \033[32mOK.\033[0m";
				break;
			default:
				echo "Adresse $ip \033[31mERREUR.\033[0m";
				break;
		}
		
		echo "\n";
	}
}

?>