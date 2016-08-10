--
-- Created by IntelliJ IDEA.
-- User: Administrator
-- Date: 2016/8/10
-- Time: 11:04
-- To change this template use File | Settings | File Templates.
--

-- initialize value when script load
local activity,title=...

-- for button class
local Button = luajava.bindClass('android.widget.Button')

-- function to add
function button(listener)
    -- create button
    local button = Button.new(activity)

    -- call object function
    title:setText('已经完成初始化了')

    button:setText('点击')
    button:setOnClickListener(listener)
    return button
end

