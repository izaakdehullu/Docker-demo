Vmmem Windows proces pakt heel veel geheugen
Dit is op te lossen door:

```shell
root@ID07642:/mnt/c/Workspaces/Docker# sudo su
root@ID07642:/mnt/c/Workspaces/Docker# echo 1 > /proc/sys/vm/compact_memory
root@ID07642:/mnt/c/Workspaces/Docker# echo 3 > /proc/sys/vm/drop_caches
```

Dit zorgt ervoor dat het wsl geheugen en de cache worden geleegd. Het geheugen gebruik gaat dan naar beneden.

Zie https://winaero.com/blog/wsl-now-has-memory-reclaim-feature/

C:\> winver
Dit commando laat de Windows versie zien. De build is de juiste.

root@ID07642:/mnt/c/Workspaces/Docker# dmesg
Dit commando laat zien dat er een memory compaction plaats vindt.

[66481.329620] WSL2: Performing memory compaction.
[66542.358583] WSL2: Performing memory compaction.
[66603.419685] WSL2: Performing memory compaction.
