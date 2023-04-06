import socket

def check_ip_conflict(ip_address):
    try:
        socket.inet_aton(ip_address)
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.bind((ip_address, 0))
    except socket.error:
        print(f"Conflict detected for IP address: {ip_address}")
    else:
        print(f"No conflict for IP address: {ip_address}")
    finally:
        s.close()

check_ip_conflict("192.168.1.100")
