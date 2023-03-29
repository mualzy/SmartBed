import json

class State:
    def __init__(self) -> None:
        self.state = {
            'temperature' : 25,
            'humidity': 65,
            'bed_wet': False,
            'baby_outbed': False, ## 如果加入超声波那就写在这
            
        }
        self.deep_state = 0 #0正常 1踢被 2异常睡姿 3空床
    
    def sensor_in(self, text):
        self.state = json.loads(text)
        self.state['deep_state'] = self.deep_state
        
    def state_out(self):
        return json.dumps(self.state)

state = State()

